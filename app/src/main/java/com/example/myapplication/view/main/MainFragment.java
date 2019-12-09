package com.example.myapplication.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.databinding.MainFragmentBinding;
import com.example.myapplication.databinding.SettingsFragmentBinding;
import com.example.myapplication.model.Settings;
import com.example.myapplication.model.TodayWeather;
import com.example.myapplication.view.details.SettingsFragment;
import com.example.myapplication.viewModel.SettingsViewModel;
import com.example.myapplication.viewModel.TodayWeatherViewModel;

public class MainFragment extends Fragment implements LifecycleOwner {
    private MainFragmentBinding mainFragmentBinding;
    private SettingsFragmentBinding settingsFragmentBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        settingsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);

        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final TodayWeatherViewModel viewModel =
                ViewModelProviders.of(this).get(TodayWeatherViewModel.class);
        mainFragmentBinding.setTodayWeatherViewModel(viewModel);

        final SettingsViewModel viewModelSetting =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        settingsFragmentBinding.setSettingsViewModel(viewModelSetting);

        observeViewModel(viewModel);
        observeSettingsViewModel(viewModelSetting);
    }

    private void observeViewModel(final TodayWeatherViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getTodayWeatherObservable().observe(this, new Observer<TodayWeather>() {
            @Override
            public void onChanged(@Nullable TodayWeather todayWeather) {
                if (todayWeather != null) {
                    //…
                    viewModel.setTodayWeather(todayWeather);
                    //projectAdapter.setProjectList(projects);
                }
            }
        });
    }

    private void observeSettingsViewModel(final SettingsViewModel viewModel) {
        viewModel.getSettingsObservable().observe(this, new Observer<Settings>() {
            @Override
            public void onChanged(@Nullable Settings settings) {
                if (settings != null) {
                    //…
                    viewModel.setSettings(settings);
                }
            }
        });
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        ImageView settings_icon = view.findViewById(R.id.main_setting);
        settings_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenSettingsFragment();
            }
        });
    }

    private void OpenSettingsFragment() {
        SettingsFragment settingsFragment = new SettingsFragment();

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, settingsFragment)
                .addToBackStack(null)
                .commit();
    }

}
