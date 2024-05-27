package com.example.retrofitmy.bottomnav.reservation;
import retrofit2.Call;
import static androidx.camera.core.impl.utils.ContextUtil.getApplicationContext;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import com.example.retrofitmy.Registrat;

import com.example.retrofitmy.R;
import com.example.retrofitmy.databinding.FragmentReservationBinding;
import com.example.retrofitmy.databinding.FragmentSearchBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ReservationFragment extends Fragment {

    private FragmentReservationBinding binding;

    TextView dateRangeText;
    MaterialButton calendar;
    Reserve reserve = new Reserve();
    Registrat service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentReservationBinding.inflate(inflater, container, false);

        Button reserveButton = binding.getRoot().findViewById(R.id.btn_reservation);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://thereawheel3.pythonanywhere.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(Registrat.class);


        Spinner spinner = binding.getRoot().findViewById(R.id.spinner_main);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {


                String item = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("МИНИ(на одного человека)");
        arrayList.add("СТАНДАРТ(на 2-х человек)");
        arrayList.add("СТАНДАРТ(на 3-х человек)");
        arrayList.add("ЛЮКС(3 и более человек)");
        arrayList.add("ЛЮКС С БАССЕЙНОМ(3 и более человек)");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);


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

                        Log.d("dkdkdkdkdkkddk", selection.toString());
                        Toast.makeText(getContext(), selection.toString(), Toast.LENGTH_LONG).show();
                        String[] temp = selection.toString().substring(5, selection.toString().length() - 1).split(" ");
                        Long t1 = Long.valueOf(temp[0]);
                        Long t2 = Long.valueOf(temp[1]);
                        Date date1 = new java.util.Date(t1);
                        Date date2 = new java.util.Date(t2);
                        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+3"));
                        String formattedDate1 = sdf.format(date1);
                        String formattedDate2 = sdf.format(date2);
                        reserve.setStart(formattedDate1);
                        reserve.setEnd(formattedDate2);
                        Log.d("dkdkdkdkdkkddk", formattedDate1 + " " + formattedDate2);
                        dateRangeText.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });


        return binding.getRoot();
    }


    public void res(){
        reserve.setEmail("test@mail.ru");
        reserve.setType("0");
        Call<String> call = service.registerUser(reserve);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getContext(), response.body(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
