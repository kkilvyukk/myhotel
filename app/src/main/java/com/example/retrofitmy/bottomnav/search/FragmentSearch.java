package com.example.retrofitmy.bottomnav.search;

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
import com.example.retrofitmy.databinding.FragmentSearchBinding;

public class FragmentSearch extends Fragment {
    private FragmentSearchBinding binding;
    CalendarView calendarView2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        CalendarView calendarView = binding.getRoot().findViewById(R.id.calendarView2);

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
