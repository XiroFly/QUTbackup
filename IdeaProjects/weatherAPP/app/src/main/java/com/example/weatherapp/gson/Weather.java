package com.example.weatherapp.gson;

import com.example.weatherapp.db.ForecastsBean;

import java.util.List;

public class Weather   {


    /**
     * status : 1
     * count : 1
     * info : OK
     * infocode : 10000
     * forecasts : [{"city":"朝阳区","adcode":"110105","province":"北京","reporttime":"2020-11-15 12:01:06","casts":
     * [{"date":"2020-11-15","week":"7","dayweather":"多云","nightweather":"多云","daytemp":"16","nighttemp":"5","daywind":"西南","nightwind":"西南","daypower":"≤3","nightpower":"≤3"},
     * {"date":"2020-11-16","week":"1","dayweather":"阴","nightweather":"阴","daytemp":"12","nighttemp":"8","daywind":"东","nightwind":"东","daypower":"≤3","nightpower":"≤3"},
     * {"date":"2020-11-17","week":"2","dayweather":"阴","nightweather":"小雨","daytemp":"13","nighttemp":"10","daywind":"西北","nightwind":"西北","daypower":"≤3","nightpower":"≤3"},
     * {"date":"2020-11-18","week":"3","dayweather":"小雨","nightweather":"小雨","daytemp":"13","nighttemp":"6","daywind":"北","nightwind":"北","daypower":"≤3","nightpower":"≤3"}
     * ]}]
     */

    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<ForecastsBean> forecasts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<ForecastsBean> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastsBean> forecasts) {
        this.forecasts = forecasts;
    }


}
