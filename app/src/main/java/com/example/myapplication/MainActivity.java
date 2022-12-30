package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchUserProfile();
    }

    private void fetchUserProfile(){
        UserProfile userProfile = new UserProfile();
        userProfile.setName("홍길동");
        userProfile.setPhone("02-2222-3333");
        userProfile.setAddress("서울");

        binding.setUserProfile(userProfile);
    }
}
