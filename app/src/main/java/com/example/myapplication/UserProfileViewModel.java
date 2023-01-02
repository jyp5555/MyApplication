package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {
    public MutableLiveData<UserProfile> liveData = new MutableLiveData<>();
}
