package com.example.retrofitmy.bottomnav.profile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;

import com.example.retrofitmy.R;
import com.example.retrofitmy.databinding.FragmentProfileBinding;
import com.google.android.material.button.MaterialButton;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    CalendarView calendarView1;
    MaterialButton btn_spa;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        CalendarView calendarView = binding.getRoot().findViewById(R.id.calendarView1);
        MaterialButton materialButton = binding.getRoot().findViewById(R.id.btn_spa);

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Данные сохранены", Toast.LENGTH_SHORT).show();
            }
        });

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            int mYear = year;
            int mMonth = month;
            int mDay = dayOfMonth;
            String selectedDate = new StringBuilder().append(mMonth + 1)
                    .append("-").append(mDay).append("-").append(mYear)
                    .append(" ").toString();
            Toast.makeText(getContext(), selectedDate, Toast.LENGTH_LONG).show();
        });
        return binding.getRoot();
    }









}




