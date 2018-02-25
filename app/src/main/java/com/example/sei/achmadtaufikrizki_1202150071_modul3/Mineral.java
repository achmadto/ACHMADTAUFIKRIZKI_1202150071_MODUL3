package com.example.sei.achmadtaufikrizki_1202150071_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Sei on 2/25/2018.
 */

public class Mineral {

    private String mineral;
    private String info;
    private int image;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    public Mineral(String mineral, String info, int image) {
        this.mineral = mineral;
        this.info = info;
        this.image = image;
    }


    public int getImage() {
        return image;
    }

    public String getInfo() {
        return info;
    }

    public String getMineral() {
        return mineral;
    }
    public static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);

        return detailIntent;
    }
}
