package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MutableLiveData<UserProfile> liveData = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        if(liveData.getValue() == null){
            fetchUserProfile();
        }

        liveData.observe(this, new Observer<UserProfile>() {
            @Override
            public void onChanged(UserProfile userProfile) {
                binding.setUserProfile(userProfile);
            }
        });

        binding.editUserProfile.setOnClickListener(view ->  {
            editUserProfile(view);
        });
    }

    private void fetchUserProfile(){
        UserProfile userProfile = new UserProfile();
        userProfile.setName("홍길동");
        userProfile.setPhone("02-2222-3333");
        userProfile.setAddress("서울");
        userProfile.setGender(0);
        userProfile.setProfileImageUrl("https://images.pexels.com/photos/13945391/pexels-photo-13945391.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load");

        liveData.setValue(userProfile);
    }

    public void editUserProfile(View view){
        UserProfile userProfile = liveData.getValue();
        Intent intent = new Intent(this, EditUserProfileActivity.class);
        intent.putExtra("phone",userProfile.getPhone());
        intent.putExtra("address",userProfile.getAddress());
        sendEditInfo.launch(intent);
    }

    ActivityResultLauncher<Intent> sendEditInfo = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result.getResultCode() == Activity.RESULT_OK){
            UserProfile userProfile = liveData.getValue();
            Intent data = result.getData();
            userProfile.setPhone(data.getStringExtra("phone"));
            userProfile.setAddress(data.getStringExtra("address"));

            liveData.setValue(userProfile);
        }
    });

}
