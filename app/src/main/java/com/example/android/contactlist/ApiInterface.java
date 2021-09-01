package com.example.android.contactlist;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("jc/android_eval.json")
    Call<User> getUsers();
}
