package com.example.solinari.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

/**
 * Created by Solinari on 2015/12/29.
 */
public class Practice_dialog extends AppCompatActivity {
    private ShareButton shareButton;
    private SharePhotoContent content ;
    private int counter = 0;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.practice_dialog);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inScaled = false;
        Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.practice_image, options);
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(bmp)
                .build();
         content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
        shareButton = (ShareButton) findViewById(R.id.share_btn);
        shareButton.setEnabled(true);
       shareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                shareButton.setShareContent(content);
            }
        });
    }
    public void ButtonClicked(View v){
            finish();
        }
    }


