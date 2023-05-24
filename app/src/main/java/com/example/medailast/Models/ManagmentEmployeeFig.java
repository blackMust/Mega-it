package com.example.medailast.Models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ManagmentEmployeeFig {
    private Drawable image;
    private String title;

    public void setImage(Drawable image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ManagmentEmployeeFig(Drawable image, String title) {
        this.image = image;
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
