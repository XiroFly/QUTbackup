package com.example.weatherapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.weatherapp.db.CastsBean;
import com.example.weatherapp.db.ForecastsBean;
import com.example.weatherapp.db.Star;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

    public class WeatherStatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_statistics_layout);
        //展示收藏的城市的未来七日天气
        List< Star> stars= LitePal.findAll(Star.class);
        for(Star star :stars){
        String adcode=star.getAdcode();
        //由地区编码获取数据库中的Weather信息
//            List<Weather> weather=LitePal.where("forecasts.adcode = ?",adcode).find(Weather.class);
//           List< Weather.ForecastsBean.CastsBean> castsBeans=weather.get(0).getForecasts().get(0).getCasts();
            //加true表示联级
           List<ForecastsBean> forecastsBeans=LitePal.where("adcode = ?",adcode).find(ForecastsBean.class,true);
           List<CastsBean> castsBeans=forecastsBeans.get(0).getCasts();
           //根据castsBeans渲染页面的一行，一行一个折线图
            LinearLayout containerLayout = findViewById(R.id.containerLayout);
            renderWeather(castsBeans, containerLayout);
        }
    }
        private void renderWeather(List<CastsBean> castsBeans, LinearLayout containerLayout) {
            LineChart lineChart = new LineChart(this);
            lineChart.setMinimumHeight(500);
            YAxis yAxisLeft = lineChart.getAxisLeft();
            yAxisLeft.setGranularity(10); // 调整刻度的间隔，根据您的数据范围调整
            lineChart.setAutoScaleMinMaxEnabled(true);
//            yAxisLeft.setAxisMinimum(-10); // 设置最小值
//            yAxisLeft.setAxisMaximum(10); // 设置最大值
            yAxisLeft.setLabelCount(5, true);
//            yAxisLeft.setGranularity(20); // 设置刻度的间隔
            containerLayout.addView(lineChart);
            //数据装入list
            List<Entry> maxTempEntries = new ArrayList<>();
            List<Entry> minTempEntries = new ArrayList<>();
            List<Entry> avgTempEntries = new ArrayList<>();

            for (int i = 0; i < castsBeans.size(); i++) {
                //  daytemp 是白天温度，nighttemp 是夜间温度
                float maxTemp = Float.parseFloat(castsBeans.get(i).getDaytemp());
                float minTemp = Float.parseFloat(castsBeans.get(i).getNighttemp());
                float avgTemp = (maxTemp + minTemp) / 2;
                 //添加坐标
                maxTempEntries.add(new Entry(i, maxTemp));
                minTempEntries.add(new Entry(i, minTemp));
                avgTempEntries.add(new Entry(i, avgTemp));
            }

            //三个坐标集
            LineDataSet maxTempDataSet = new LineDataSet(maxTempEntries, "最高温度");
            maxTempDataSet.setColor(Color.RED);
            maxTempDataSet.setValueTextColor(Color.BLACK);

            LineDataSet minTempDataSet = new LineDataSet(minTempEntries, "最低温度");
            minTempDataSet.setColor(Color.BLUE);
            minTempDataSet.setValueTextColor(Color.BLACK);

            LineDataSet avgTempDataSet = new LineDataSet(avgTempEntries, "平均温度");
            avgTempDataSet.setColor(Color.GREEN);
            avgTempDataSet.setValueTextColor(Color.BLACK);

//
            LineData lineData = new LineData(maxTempDataSet,minTempDataSet,avgTempDataSet);

            lineChart.setData(lineData);

            Description description = new Description();
            description.setText("4天天气预报");
            lineChart.setDescription(description);

            XAxis xAxis = lineChart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues(castsBeans)));
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

            YAxis yAxisRight = lineChart.getAxisRight();
            yAxisRight.setEnabled(false);

            lineChart.invalidate(); // 刷新图表
        }

        private List<String> getXAxisValues(List<CastsBean> castsBeans) {
            List<String> xAxisValues = new ArrayList<>();

            for (CastsBean castsBean : castsBeans) {
                //  date 是 X 轴的值
                xAxisValues.add(castsBean.getDate());
            }

            return xAxisValues;
        }
        }
