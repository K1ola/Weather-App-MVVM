package com.example.myapplication.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Settings {
    public final static String CELSIUS = "°C";
    public final static String FAHRENHEIT = "°F";

    public final static String MM_HG = "мм рт.ст.";
    public final static String HPA = "гПа";

    public final static String METERS_PER_SECOND ="м/с";
    public final static String HOURS_PER_SECOND ="км/ч";

    public String currentTemperatureMeasure;
    public String currentPressureMeasure;
    public String currentWindMeasure;

    public boolean isCelsius;
    public boolean isHpa;
    public boolean isMeters;

    private Settings() {}

    private Settings(boolean temperature, boolean pressure, boolean wind) {
        this.isCelsius = temperature;
        this.isHpa = pressure;
        this.isMeters = wind;
    }

    private Settings(String temperature, String pressure, String wind) {
        this.currentTemperatureMeasure = temperature;
        this.currentPressureMeasure = pressure;
        this.currentWindMeasure = wind;
    }

    public static Settings getInstance() {
        return new Settings();
    }

    public LiveData<Settings> getSettings() {
        MutableLiveData<Settings> data = new MutableLiveData<>();
        data.setValue(currentMeasure());
        return data;
    }

    private Settings currentMeasure() {
        Settings settings = new Settings();
        settings.currentTemperatureMeasure = this.isCelsius ? CELSIUS : FAHRENHEIT;
        settings.currentPressureMeasure = this.isHpa ? HPA : MM_HG;
        settings.currentWindMeasure = this.isMeters ? METERS_PER_SECOND : HOURS_PER_SECOND;
        return settings;
    }
}
