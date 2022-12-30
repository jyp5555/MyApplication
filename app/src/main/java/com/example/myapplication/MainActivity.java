package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name, phone, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);

        fetchUserProfile();
    }

    private void fetchUserProfile(){
        UserProfile userProfile = new UserProfile();
        userProfile.setName("홍길동");
        userProfile.setPhone("02-2222-3333");
        userProfile.setAddress("서울");

        updateUI(userProfile);
    }

    private void updateUI(UserProfile userProfile){
        name.setText(userProfile.getName());
        phone.setText(userProfile.getPhone());
        address.setText(userProfile.getAddress());
    }
}