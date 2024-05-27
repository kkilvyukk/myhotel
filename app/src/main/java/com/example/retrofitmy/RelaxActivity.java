package com.example.retrofitmy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitmy.bottomnav.AdminActivity;
import com.example.retrofitmy.bottomnav.RestActivity;

public class RelaxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax);
    }

    public void spa(View view) {
    }

    public void rest1(View view) {
        startActivity(new Intent(RelaxActivity.this, RestActivity.class));
    }

    public void res(View view) {
        startActivity(new Intent(RelaxActivity.this, AdminActivity.class));
    }
}