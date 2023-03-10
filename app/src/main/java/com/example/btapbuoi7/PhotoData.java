package com.example.btapbuoi7;

import android.content.Context;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PhotoData {
    public static Photo getPhotoFromId(int id, Context context) {
        ArrayList<Photo> phs = generatePhotoData(context);
        for (int i = 0; i < phs.size(); i++)
            if (phs.get(i).getId() == id)
                return phs.get(i);
        return null;
    }

    static ArrayList<Photo> generatePhotoData(Context context) {
        ArrayList<Photo> photos = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("PhotoData.json");
            int size = inputStream.available();
            byte[] bytes = new byte[size];
            inputStream.read(bytes);
            inputStream.close();


            String json = new String(bytes, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);

            int max = jsonArray.length();
            int id;
            String url, title, description;

            for (int i = 0; i < max; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getInt("id");
                url = jsonObject.getString("url");
                title = jsonObject.getString("title");
                description = jsonObject.getString("description");
                photos.add(new Photo(id, url, title, description));
            }
            return photos;

        } catch (JSONException | IOException e) {
            return null;
        }
    }


}
