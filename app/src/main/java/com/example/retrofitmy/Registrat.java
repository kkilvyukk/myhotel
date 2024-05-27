package com.example.retrofitmy;

import com.example.retrofitmy.bottomnav.reservation.Reserve;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Registrat {
    @POST("/reservation")
    Call<String> registerUser(@Body Reserve reserve);

}
