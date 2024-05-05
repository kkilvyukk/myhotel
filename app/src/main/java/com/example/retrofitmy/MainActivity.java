package com.example.retrofitmy;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.graphics.Path;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitmy.bottomnav.profile.ProfileFragment;
import com.example.retrofitmy.bottomnav.reservation.ReservationFragment;
import com.example.retrofitmy.bottomnav.search.FragmentSearch;
import com.example.retrofitmy.databinding.ActivityMainBinding;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            startActivity(new Intent(MainActivity.this, Login.class));
        }

        getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), new FragmentSearch()).commit();
        binding.bottomNav.setSelectedItemId(R.id.search);

        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.search, new FragmentSearch());
        fragmentMap.put(R.id.reservation, new ReservationFragment());
        fragmentMap.put(R.id.profile, new ProfileFragment());

        binding.bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), fragment).commit();




            return true;
        });

    }
}
