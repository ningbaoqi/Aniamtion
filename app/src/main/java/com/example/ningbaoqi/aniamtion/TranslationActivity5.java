package com.example.ningbaoqi.aniamtion;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TranslationActivity5 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frameanimation);
    }

    public void start(View view) {
        startActivity(new Intent(this, TranslationActivity6.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
