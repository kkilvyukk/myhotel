package com.example.retrofitmy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitmy.bottomnav.AdminActivity;
import com.example.retrofitmy.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "LocalSuppress"})


    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());








    }

    public void reg(View view) {



        if (binding.email.getText().toString().isEmpty() || binding.password.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Вы не заполнили все поля", Toast.LENGTH_SHORT).show();
        }else{
            if (binding.email.getText().toString().equals("admin123@gmail.com") && binding.password.getText().toString().equals("123456789admin0")){
                startActivity(new Intent(Login.this, AdminActivity.class));
            }
            else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.email.getText().toString(), binding.password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(Login.this, MainActivity.class));
                                }
                            }
                        });
            }
        }
    }



    public void sign(View view) {
        startActivity(new Intent(Login.this, Register.class));
    }
}

