package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.databinding.ActivityEditUserProfileBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

public class EditUserProfileActivity extends AppCompatActivity {

    private ActivityEditUserProfileBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding1 = ActivityEditUserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding1.getRoot());

        UserProfile userProfile = new UserProfile();
        userProfile.setPhone(getIntent().getStringExtra("phone"));
        userProfile.setAddress(getIntent().getStringExtra("address"));
        binding1.setUserProfile(userProfile);

        binding1.saveEdit.setOnClickListener(view -> {
            saveEdit(view);
        });
        binding1.cancelEdit.setOnClickListener(view -> {
            cancelEdit(view);
        });
    }

    public void saveEdit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("phone",binding1.editPhone.getText().toString());
        intent.putExtra("address",binding1.editAddress.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }

    public void cancelEdit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        setResult(RESULT_CANCELED,intent);
        finish();
    }
}