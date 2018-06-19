package com.example.ningbaoqi.aniamtion;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class PropertyAnimatorXMLActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweenanimation);
        imageView = (ImageView) findViewById(R.id.imageview);
    }
    public void click(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.propertyanimator);
        animator.setTarget(imageView);
        animator.start();
    }
}
