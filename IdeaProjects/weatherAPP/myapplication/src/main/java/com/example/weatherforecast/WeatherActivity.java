package com.example.weatherforecast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.weatherforecast.gson.NowWeather;
import com.example.weatherforecast.gson.Weather;
import com.example.weatherforecast.gson.ip;
import com.example.weatherforecast.service.AutoUpdateService;
import com.example.weatherforecast.util.HttpUtil;
import com.example.weatherforecast.util.Utility;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class WeatherActivity extends AppCompatActivity {

    String TAG = "WeatherActivity";
    public SwipeRefreshLayout swipeRefresh;
    public DrawerLayout drawerLayout;
    public Button navButton;
    public Button stasticButton;
//    public SearchView search_input;
//    public Button star_button;
//    public Button list_button;

    private ScrollView weatherLayout;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView degreeText;
    private TextView weatherInfoText;
    private LinearLayout forecastLayout;
    private TextView humidityText;
    private TextView winddirectionText;
    private TextView windpowerText;

    private StringBuilder datesBuilder ;
    private StringBuilder maxTempsBuilder ;
    private StringBuilder minTempsBuilder ;


    private String weatherId;   //把weatheId定义在外部，方便后面刷新更新

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

    }


    //因为我给weatheractivity设置的启动模式是sigletask，所以从star列表返回后会从onStart开始执行
    @Override
    protected void onStart() {
        super.onStart();

        //初始化各控件
        stasticButton=(Button)findViewById(R.id.Stastic_button);
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        titleCity = (TextView) findViewById(R.id.title_city);
        titleUpdateTime = (TextView) findViewById(R.id.title_update_time);
        degreeText = (TextView) findViewById(R.id.degree_text);
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        humidityText = (TextView) findViewById(R.id.humidity_text);
        winddirectionText = (TextView) findViewById(R.id.winddirection_text);
        windpowerText = (TextView) findViewById(R.id.windpower_text);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);

        //实现关注功能
        //从sharePreference取出Weatherid
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        weatherId = prefs.getString("weather_id", null);


        //从sharePreference取出Weather和NowWeather
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("weather", null);
        String nowWeatherString = prefs.getString("nowWeather", null);

        Log.d(TAG, "onCreate: xxxxxxxxxxxxxxxxxxxxxxxxxx");
        if (weatherString != null && nowWeatherString != null) {
            //有缓存时直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherString);
            NowWeather nowWeather = Utility.handleNowWeatherResponse(nowWeatherString);

            weatherId = weather.getForecasts().get(0).getAdcode();
            Log.d(TAG, "onCreate: " + weatherId);
            //展示数据
            showWeatherInfo(weather);
            showNowWeatherInfo(nowWeather);

        } else {
            //无缓存时去服务器查询天气
            weatherId = getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            Log.d(TAG, "onStart:  intent " + weatherId);

            //如果不是intent传过来，从shanrepref中获取weatherId
            if (weatherId == null) {
                //从sharePreference取出Weather和NowWeather
                weatherId = prefs.getString("weather_id", null);
                if (weatherId == null){
                    //如果这是sharepre中为空，说明是程序刚启动
                    //访问IP，将adcode存到sharepref中
                    weatherId = requestIp();
                }else {
                    Log.d(TAG, "onStart: intent null " + weatherId);
                    requestWeather(weatherId);
                    requestNowWeather(weatherId);
                }

            } else {
                //如果intent传过来不为空，说明是通过切换城市访问的，这时去服务器获取并展示数据
                requestWeather(weatherId);
                requestNowWeather(weatherId);
            }
        }


        //下拉刷新，根据weatheId重新去服务器请求加载到界面
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                System.out.println("123");
                //从sharepref中读取weatherId，为了解决刷新的问题
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this);
                weatherId = prefs.getString("weather_id", null);

                Log.d(TAG, "onRefresh: " + weatherId);
                requestWeather(weatherId);
                requestNowWeather(weatherId);
            }
        });

        //滑动显示菜单的实现
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navButton = (Button) findViewById(R.id.nav_button);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("123");
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //统计图表
        stasticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // 创建 Intent 跳转到 StasticActivity
                    Intent intent = new Intent(WeatherActivity.this, StasticActivity.class);

                    // 将当前地区信息传递给 StasticActivity
                    intent.putExtra("cityName", titleCity.getText().toString());
                    System.out.println(titleCity.getText().toString());
                    // 将拼接的日期和温度数据传递给 StasticActivity
                    intent.putExtra("dates", datesBuilder.toString());
                    System.out.println(datesBuilder.toString());
                    intent.putExtra("maxTemps", maxTempsBuilder.toString());
                    System.out.println(maxTempsBuilder.toString());
                    intent.putExtra("minTemps", minTempsBuilder.toString());
                    System.out.println(minTempsBuilder.toString());
                    // 启动 StasticActivity
                    startActivity(intent);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //根据请求获取位置信息
    public String requestIp(){
        String ipUrl = "https://restapi.amap.com/v3/ip?key=f277e7e769384c5f002c1ecf16143aae";
        HttpUtil.sendOkHttpRequest(ipUrl, new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseText = response.body().string();
                final ip ip = Utility.handleIpResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (ip != null && "1".equals(ip.getStatus())){
                            Log.d(TAG, "run: " + ip.getAdcode());
                            //将查询到的adcode存入缓存
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather_id",ip.getAdcode());   //将weatherid更新
                            editor.apply();

                            //
                            requestWeather(ip.getAdcode());
                            requestNowWeather(ip.getAdcode());
                        }else {
                            Toast.makeText(WeatherActivity.this,"获取位置信息失败",Toast.LENGTH_SHORT).show();
                        }
                        //默认不刷新
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this,"获取位置信息失败",Toast.LENGTH_SHORT).show();
                        //默认不刷新
                        swipeRefresh.setRefreshing(false);
                    }
                });

            }
        });
        return ipUrl;
    }

    //根据天气id请求城市weather信息
    public void requestWeather(final String weatherId){
        Log.d(TAG, "requestWeather: " + weatherId);
        String weatherUrl = "https://restapi.amap.com/v3/weather/weatherInfo?key=f277e7e769384c5f002c1ecf16143aae&city=" + weatherId + "&extensions=all&output=JSON";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseText = response.body().string();
                final Weather weather = Utility.handleWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "1".equals(weather.getCount())){
                            Log.d(TAG, "run: ------------------------------------------");
//                            Log.d(TAG, "run: " + responseText);
                            //将查询到的weather存入缓存
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather",responseText);
                            editor.putString("weather_id",weatherId);   //将weatherid更新
                            editor.apply();
                            //展示数据
                            showWeatherInfo(weather);
                        }else {
                            Toast.makeText(WeatherActivity.this,"输入的编码有误",Toast.LENGTH_SHORT).show();
                        }
                        //默认不刷新
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this,"获取未来天气信息失败",Toast.LENGTH_SHORT).show();
                        //默认不刷新
                        swipeRefresh.setRefreshing(false);
                    }
                });

            }
        });
    }

    //根据天气id请求城市nowWeather信息
    public void requestNowWeather(final String weatherId){
        String weatherUrl = "https://restapi.amap.com/v3/weather/weatherInfo?key=f277e7e769384c5f002c1ecf16143aae&city=" + weatherId + "&output=JSON";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseText = response.body().string();
                final NowWeather nowWeather = Utility.handleNowWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (nowWeather != null && "1".equals(nowWeather.getCount())){
//                            Log.d(TAG, "run: " + responseText);
                            //将查询到的weather存入缓存
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("nowWeather",responseText);
                            editor.putString("weather_id",weatherId);   //将weatherid更新
                            editor.apply();
                            //展示数据
                            showNowWeatherInfo(nowWeather);
                        }else {
                            Toast.makeText(WeatherActivity.this,"输入的编码有误",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this,"获取今天天气信息失败",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    //处理并展示weather实体类中的数据
    private void showWeatherInfo(Weather weather){
        forecastLayout.removeAllViews();

        datesBuilder = new StringBuilder();
        maxTempsBuilder = new StringBuilder();
        minTempsBuilder = new StringBuilder();

        for (Weather.ForecastsBean.CastsBean castsBean : weather.getForecasts().get(0).getCasts()){
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item,forecastLayout,false);
            TextView dateText = (TextView) view.findViewById(R.id.date_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
//            Log.d(TAG, "showWeatherInfo: " + castsBean.getDate());
            dateText.setText(castsBean.getDate());
            infoText.setText(castsBean.getDayweather() + "～" + castsBean.getNightweather());
            maxText.setText(castsBean.getDaytemp() + "°C");
            minText.setText(castsBean.getNighttemp() + "°C");

            datesBuilder.append(castsBean.getDate()).append(",");
            maxTempsBuilder.append(castsBean.getDaytemp()).append(",");
            minTempsBuilder.append(castsBean.getNighttemp()).append(",");

            forecastLayout.addView(view);
        }

        weatherLayout.setVisibility(View.VISIBLE);

        //在autoservice中我们写了每隔8h自动更新缓存中的数据
        //在这里激活
        Intent intent = new Intent(this, AutoUpdateService.class);
        startService(intent);
    }

    //处理并展示nowWeather实体类中的数据
    private void showNowWeatherInfo(NowWeather nowWeather){
        String cityName = nowWeather.getLives().get(0).getCity();
        String updateTime = nowWeather.getLives().get(0).getReporttime();
        String degree = nowWeather.getLives().get(0).getTemperature() + "°C";
        String weatherInfo = nowWeather.getLives().get(0).getWeather();
        String humidity = nowWeather.getLives().get(0).getHumidity();
        String winddirection = nowWeather.getLives().get(0).getWinddirection();
        String windpower = nowWeather.getLives().get(0).getWindpower();

        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        humidityText.setText(humidity);
        winddirectionText.setText(winddirection);
        windpowerText.setText(windpower);

        weatherLayout.setVisibility(View.VISIBLE);

        //在autoservice中我们写了每隔8h自动更新缓存中的数据
        //在这里激活
        Intent intent = new Intent(this, AutoUpdateService.class);
        startService(intent);

    }

}