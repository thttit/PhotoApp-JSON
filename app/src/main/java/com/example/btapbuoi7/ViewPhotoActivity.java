package com.example.btapbuoi7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPhotoActivity extends AppCompatActivity {

    ImageView iv_detail;
    TextView tv_detail_title, tv_detail_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);

        iv_detail = findViewById(R.id.iv_detail);
        tv_detail_title = findViewById(R.id.detail_title);
        tv_detail_description = findViewById(R.id.tv_detail_description);

        int id = (int) getIntent().getLongExtra("id",0);

        Picasso.get().load((PhotoData.getPhotoFromId(id, getApplicationContext()).getSource_photo())).into(iv_detail);
        tv_detail_title.setText((PhotoData.getPhotoFromId(id, getApplicationContext()).getTitle_photo()));
        tv_detail_description.setText((PhotoData.getPhotoFromId(id,getApplicationContext()).getDescription_photo()));
    }
}