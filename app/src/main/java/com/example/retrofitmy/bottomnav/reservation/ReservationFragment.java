package com.example.retrofitmy.bottomnav.reservation;

import static androidx.camera.core.impl.utils.ContextUtil.getApplicationContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import com.example.retrofitmy.R;
import com.example.retrofitmy.databinding.FragmentReservationBinding;
import com.example.retrofitmy.databinding.FragmentSearchBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class ReservationFragment extends Fragment {

    private FragmentReservationBinding binding;

    TextView dateRangeText;
    MaterialButton calendar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentReservationBinding.inflate(inflater, container, false);

        TextView dateRangeText = binding.getRoot().findViewById(R.id.text);
        MaterialButton calendar = binding.getRoot().findViewById(R.id.calendar);
        MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.dateRangePicker().
                setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getActivity().getSupportFragmentManager(), "Tag_picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        dateRangeText.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });


        return binding.getRoot();
    }

}
