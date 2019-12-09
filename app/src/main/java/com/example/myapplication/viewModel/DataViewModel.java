package com.example.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Settings;
import com.example.myapplication.model.TodayWeather;

public class DataViewModel extends AndroidViewModel {
    private final LiveData<Settings> settingsObservable;
    public ObservableField<Settings> settings = new ObservableField<>();

    private final LiveData<TodayWeather> todayWeatherObservable;
    public ObservableField<TodayWeather> todayWeather = new ObservableField<>();

    public DataViewModel(@NonNull Application application) {
        super(application);

        settingsObservable = Settings.getInstance().getSettings();
        todayWeatherObservable = TodayWeather.getInstance().getTodayWeather();
    }

    public LiveData<Settings> getSettingsObservable() {
        return settingsObservable;
    }
    public LiveData<TodayWeather> getTodayWeatherObservable() {
        return todayWeatherObservable;
    }

    public void setSettings(Settings settings) {
        this.settings.set(settings);
    }

    public void setTodayWeather(TodayWeather todayWeather) {
        this.todayWeather.set(todayWeather);
    }

}
