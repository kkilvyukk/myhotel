package com.example.retrofitmy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrofitmy.databinding.ActivityLoginBinding;
import com.example.retrofitmy.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void registr(View view) {
        if (binding.email1.getText().toString().isEmpty() || binding.password1.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Вы не заполнили все поля", Toast.LENGTH_SHORT).show();
        }else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.email1.getText().toString(), binding.password1.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                HashMap<String, String> userInfo = new HashMap<>();
                                userInfo.put("email",binding.email1.getText().toString());
                                FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(userInfo);
                                startActivity(new Intent(Register.this, MainActivity.class));

                            }
                        }
                    });

        }
    }

    public void log(View view) {
        startActivity(new Intent(Register.this, Login.class));
    }
}