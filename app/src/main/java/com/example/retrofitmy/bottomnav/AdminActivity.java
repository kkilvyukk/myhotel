package com.example.retrofitmy.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitmy.R;
import com.example.retrofitmy.RelaxActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void rest(View view) {
        startActivity(new Intent(AdminActivity.this, RestActivity.class));
    }

    public void spa(View view) {
        startActivity(new Intent(AdminActivity.this, RelaxActivity.class));
    }
}