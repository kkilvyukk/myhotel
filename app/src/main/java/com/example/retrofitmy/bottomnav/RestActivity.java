package com.example.retrofitmy.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitmy.R;
import com.example.retrofitmy.RelaxActivity;

public class RestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
    }

    public void spa(View view) {
        startActivity(new Intent(RestActivity.this, RelaxActivity.class));
    }

    public void res1(View view) {
        startActivity(new Intent(RestActivity.this, AdminActivity.class));
    }
}