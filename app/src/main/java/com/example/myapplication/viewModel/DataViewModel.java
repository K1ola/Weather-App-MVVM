package com.example.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.model.Settings;
import com.example.myapplication.model.TodayWeather;

public class DataViewModel extends AndroidViewModel {
    private final MutableLiveData<Settings> settingsObservable;
    public ObservableField<Settings> settings = new ObservableField<>();

    private final MutableLiveData<TodayWeather> todayWeatherObservable;
    public ObservableField<TodayWeather> todayWeather = new ObservableField<>();

    public DataViewModel(@NonNull Application application) {
        super(application);

        settingsObservable = getSettings();
        todayWeatherObservable = getTodayWeather();
    }

    public LiveData<Settings> getSettingsObservable() {
        return settingsObservable;
    }
    public LiveData<TodayWeather> getTodayWeatherObservable() {
        return todayWeatherObservable;
    }

    public void setSettings(Settings settings) {
//        settingsObservable.setValue(settings);
        this.settings.set(settings);
    }

    public MutableLiveData<Settings> getSettings() {
        MutableLiveData<Settings> data = new MutableLiveData<>();
        data.setValue(Settings.currentMeasure());
        return data;
    }

    public void setTodayWeather(TodayWeather todayWeather) {
//        todayWeatherObservable.setValue(todayWeather);
        this.todayWeather.set(todayWeather);
    }

    public MutableLiveData<TodayWeather> getTodayWeather() {
        MutableLiveData<TodayWeather> data = new MutableLiveData<>();
        data.setValue(new TodayWeather("some temp","some press",
                "some wet",
                "some wind"));
        return data;
    }

}
