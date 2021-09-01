package com.example.android.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsScreenActivity extends AppCompatActivity {

    ImageView img;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        img = findViewById(R.id.desc_img);
        tv1 = findViewById(R.id.desc_header);
        tv2 = findViewById(R.id.desc_desc);

        Bundle extras = getIntent().getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("image_url");
        img.setImageBitmap(bmp );
        //img.setImageResource(Integer.parseInt(getIntent().getStringExtra("image_url")));
        tv1.setText(getIntent().getStringExtra("name"));
        tv2.setText(getIntent().getStringExtra("position"));
    }
}