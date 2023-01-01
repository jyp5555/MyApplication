package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserProfile userProfile;
    private MutableLiveData<UserProfile> liveData = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        fetchUserProfile();

        binding.editUserProfile.setOnClickListener(view ->  {
            editUserProfile(view);
        });
    }

    private void fetchUserProfile(){
        userProfile = new UserProfile();
        userProfile.setName("홍길동");
        userProfile.setPhone("02-2222-3333");
        userProfile.setAddress("서울");
        userProfile.setGender(0);
        userProfile.setProfileImageUrl("https://images.pexels.com/photos/13945391/pexels-photo-13945391.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load");

        binding.setUserProfile(userProfile);
    }

    public void editUserProfile(View view){
        Intent intent = new Intent(this, EditUserProfileActivity.class);
        intent.putExtra("phone",userProfile.getPhone());
        intent.putExtra("address",userProfile.getAddress());
        sendEditInfo.launch(intent);
    }

    ActivityResultLauncher<Intent> sendEditInfo = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result.getResultCode() == Activity.RESULT_OK){
            Intent data = result.getData();
            userProfile.setPhone(data.getStringExtra("phone"));
            userProfile.setAddress(data.getStringExtra("address"));

            binding.setUserProfile(userProfile);
        }
    });

}
