package com.example.btapbuoi7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
    private final ImageView imageview;
    private ImageView imageView;

    public DownloadImage(ImageView imageview) {
        this.imageview = imageview;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String urls = strings[0];
        Bitmap result = null;
        try {
            URL url = new URL(urls);
            URLConnection connection = url.openConnection();
            connection.setUseCaches(true);
            InputStream in = url.openStream();
            result = BitmapFactory.decodeStream(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}