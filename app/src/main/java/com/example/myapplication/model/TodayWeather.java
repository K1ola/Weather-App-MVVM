package com.example.myapplication.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class TodayWeather {
    public String temperature;
    public String pressure;
    public String wet;
    public String wind;

    private TodayWeather() {}

    private TodayWeather(String temperature, String pressure, String wet, String wind) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.wet = wet;
        this.wind =wind;
    }

    public static TodayWeather getInstance() {
        return new TodayWeather();
    }

    public MutableLiveData<TodayWeather> getTodayWeather() {
        MutableLiveData<TodayWeather> data = new MutableLiveData<>();
        data.setValue(new TodayWeather("some temp","some press",
                "some wet",
                "some wind"));
        return data;
    }
}