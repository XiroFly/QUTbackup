package com.example.weatherapp.db;

import org.litepal.crud.LitePalSupport;

public  class CastsBean  extends LitePalSupport {


    /**
     * date : 2020-11-15
     * week : 7
     * dayweather : 多云
     * nightweather : 多云
     * daytemp : 16
     * nighttemp : 5
     * daywind : 西南
     * nightwind : 西南
     * daypower : ≤3
     * nightpower : ≤3
     */
    private int id;
    private String date;
    private String week;
    private String dayweather;
    private String nightweather;
    private String daytemp;
    private String nighttemp;
    private String daywind;
    private String nightwind;
    private String daypower;
    private String nightpower;
    private ForecastsBean forecastsBean;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ForecastsBean getForecastsBean() {
        return forecastsBean;
    }

    public void setForecastsBean(ForecastsBean forecastsBean) {
        this.forecastsBean = forecastsBean;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDayweather() {
        return dayweather;
    }

    public void setDayweather(String dayweather) {
        this.dayweather = dayweather;
    }

    public String getNightweather() {
        return nightweather;
    }

    public void setNightweather(String nightweather) {
        this.nightweather = nightweather;
    }

    public String getDaytemp() {
        return daytemp;
    }

    public void setDaytemp(String daytemp) {
        this.daytemp = daytemp;
    }

    public String getNighttemp() {
        return nighttemp;
    }

    public void setNighttemp(String nighttemp) {
        this.nighttemp = nighttemp;
    }

    public String getDaywind() {
        return daywind;
    }

    public void setDaywind(String daywind) {
        this.daywind = daywind;
    }

    public String getNightwind() {
        return nightwind;
    }

    public void setNightwind(String nightwind) {
        this.nightwind = nightwind;
    }

    public String getDaypower() {
        return daypower;
    }

    public void setDaypower(String daypower) {
        this.daypower = daypower;
    }

    public String getNightpower() {
        return nightpower;
    }

    public void setNightpower(String nightpower) {
        this.nightpower = nightpower;
    }
}