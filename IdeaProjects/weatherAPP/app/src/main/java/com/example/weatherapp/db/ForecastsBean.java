package com.example.weatherapp.db;

import org.litepal.crud.LitePalSupport;

import java.util.List;

public  class ForecastsBean extends LitePalSupport {
    /**
     * city : 朝阳区
     * adcode : 110105
     * province : 北京
     * reporttime : 2020-11-15 12:01:06
     * casts : [{"date":"2020-11-15","week":"7","dayweather":"多云","nightweather":"多云","daytemp":"16","nighttemp":"5","daywind":"西南","nightwind":"西南","daypower":"≤3","nightpower":"≤3"},{"date":"2020-11-16","week":"1","dayweather":"阴","nightweather":"阴","daytemp":"12","nighttemp":"8","daywind":"东","nightwind":"东","daypower":"≤3","nightpower":"≤3"},{"date":"2020-11-17","week":"2","dayweather":"阴","nightweather":"小雨","daytemp":"13","nighttemp":"10","daywind":"西北","nightwind":"西北","daypower":"≤3","nightpower":"≤3"},{"date":"2020-11-18","week":"3","dayweather":"小雨","nightweather":"小雨","daytemp":"13","nighttemp":"6","daywind":"北","nightwind":"北","daypower":"≤3","nightpower":"≤3"}]
     */
    private int id;

    private String city;
    private String adcode;
    private String province;
    private String reporttime;
    private List<CastsBean> casts;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getReporttime() {
        return reporttime;
    }

    public void setReporttime(String reporttime) {
        this.reporttime = reporttime;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }


}