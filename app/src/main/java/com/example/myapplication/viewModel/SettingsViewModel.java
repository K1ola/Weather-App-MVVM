package com.example.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Settings;

public class SettingsViewModel extends AndroidViewModel {
    private final LiveData<Settings> settingsObservable;
    public ObservableField<Settings> settings = new ObservableField<>();

    public SettingsViewModel(@NonNull Application application) {
        super(application);

        settingsObservable = Settings.getInstance().getSettings();
    }

    public LiveData<Settings> getSettingsObservable() {
        return settingsObservable;
    }

    public void setSettings(Settings settings) {
        this.settings.set(settings);
    }
}
