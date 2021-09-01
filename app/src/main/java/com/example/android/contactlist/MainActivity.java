package com.example.android.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserRoasterAdapter userRoasterAdapter;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.roaster_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadThirdPartyApiData();
    }

    private void loadThirdPartyApiData() {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getUsers().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    List<Data> userList = response.body().getRoster();
                    for (int i=0; i<userList.size();i++){

                        userRoasterAdapter =new UserRoasterAdapter((ArrayList<Data>) userList, getApplicationContext());
                        recyclerView.setAdapter(userRoasterAdapter);
                        userRoasterAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}