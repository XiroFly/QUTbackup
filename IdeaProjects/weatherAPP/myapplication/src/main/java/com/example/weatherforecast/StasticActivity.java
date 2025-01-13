package com.example.weatherforecast;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class StasticActivity extends AppCompatActivity {

    private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stastic);

//        test=(TextView)findViewById(R.id.text001);
        Intent intent = getIntent();
        if (intent != null) {
            String cityName = intent.getStringExtra("cityName");
            String datesString = intent.getStringExtra("dates");
            String maxTempsString = intent.getStringExtra("maxTemps");
            String minTempsString = intent.getStringExtra("minTemps");
//            test.setText(cityName);
//            // 将日期和温度数据分割成数组
            final String[] dates = datesString.split(",");
            String[] maxTemps = maxTempsString.split(",");
            String[] minTemps = minTempsString.split(",");

            // 创建 LineChart 对象
            LineChart lineChart = findViewById(R.id.lineChart);

            // 创建最高温度的 LineDataSet
            LineDataSet maxTempDataSet = createLineDataSet("最高温度", Color.RED);
            for (int i = 0; i < dates.length; i++) {
                maxTempDataSet.addEntry(new Entry(i, Float.parseFloat(maxTemps[i])));
            }

            // 创建最低温度的 LineDataSet
            LineDataSet minTempDataSet = createLineDataSet("最低温度", Color.BLUE);
            for (int i = 0; i < dates.length; i++) {
                minTempDataSet.addEntry(new Entry(i, Float.parseFloat(minTemps[i])));
            }

            // 创建 LineData，并将两个 LineDataSet 添加到 LineData 中
            LineData lineData = new LineData();
            lineData.addDataSet(maxTempDataSet);
            lineData.addDataSet(minTempDataSet);

            // 设置 X 轴和 Y 轴的属性
            XAxis xAxis = lineChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            // 设置 X 轴的标签值
            // 设置 X 轴的标签值
            xAxis.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    int index = (int) value;
                    if (index >= 0 && index < dates.length) {
                        // 假设 dates 的格式为 "yyyy-MM-dd"
                        String fullDate = dates[index];

                        // 将 "yyyy-MM-dd" 格式的日期转换为 "MM-dd"
                        String[] parts = fullDate.split("-");
                        if (parts.length == 3) {
                            return parts[1] + "-" + parts[2];
                        }
                    }
                    return ""; // 处理越界情况或日期格式错误
                }
            });

            xAxis.setGranularity(1f);  // 设置X轴值的间隔，这里设置为1表示一个点一个横坐标值
            // 设置X轴标签的数量为点的数量
            xAxis.setLabelCount(dates.length); // 这里假设最多显示5个标签，根据实际情况调整

            YAxis leftAxis = lineChart.getAxisLeft();
            YAxis rightAxis = lineChart.getAxisRight();
            rightAxis.setEnabled(false);

            // 设置图表的一些属性
            Description description = new Description();
            description.setText(cityName + " 温度变化");
            lineChart.setDescription(description);
            lineChart.setData(lineData);
            lineChart.invalidate();  // 刷新图表

            // 设置图例
            Legend legend = lineChart.getLegend();
            legend.setForm(Legend.LegendForm.LINE);
        }
    }

    // 创建 LineDataSet 的方法
    private LineDataSet createLineDataSet(String label, int color) {
        LineDataSet dataSet = new LineDataSet(null, label);
        dataSet.setLineWidth(2f);
        dataSet.setColor(color);
        dataSet.setDrawCircleHole(false);
        dataSet.setDrawCircles(true);
        dataSet.setCircleColor(color);
        dataSet.setDrawValues(true);  // 显示每个点的数值
        dataSet.setValueTextSize(12f);  // 设置数值字体大小
        return dataSet;
    }
}