package com.example.retrofitmy.bottomnav.reservation;

import static androidx.camera.core.impl.utils.ContextUtil.getApplicationContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.retrofitmy.R;
import com.example.retrofitmy.databinding.FragmentReservationBinding;
import com.example.retrofitmy.databinding.FragmentSearchBinding;

public class ReservationFragment extends Fragment {

    private FragmentReservationBinding binding;


    CalendarView calendarView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentReservationBinding.inflate(inflater, container, false);

        CalendarView calendarView = binding.getRoot().findViewById(R.id.calendarView);






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

    private Context getApplicationContext() {
        return null;
    }
}
