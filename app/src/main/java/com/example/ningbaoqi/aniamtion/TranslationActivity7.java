package com.example.ningbaoqi.aniamtion;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.View;

public class TranslationActivity7 extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bn1);
    }

    public void start(View view) {
        startActivity(new Intent(this,TranslationActivity8.class), ActivityOptions.makeSceneTransitionAnimation(this,view,"bn1").toBundle());
    }
}
