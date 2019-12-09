package com.example.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.model.TodayWeather;

public class TodayWeatherViewModel extends AndroidViewModel {
    private final LiveData<TodayWeather> todayWeatherObservable;
    public ObservableField<TodayWeather> todayWeather = new ObservableField<>();

    public TodayWeatherViewModel(@NonNull Application application) {
        super(application);

        todayWeatherObservable = TodayWeather.getInstance().getTodayWeather();
    }

    public LiveData<TodayWeather> getTodayWeatherObservable() {
        return todayWeatherObservable;
    }

    public void setTodayWeather(TodayWeather todayWeather) {
        this.todayWeather.set(todayWeather);
    }
}
