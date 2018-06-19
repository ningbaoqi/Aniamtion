package com.example.ningbaoqi.aniamtion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class JavaTweenActivity extends AppCompatActivity {
    private ImageView imageView;
    private AlphaAnimation alphaAnimation;
    private ScaleAnimation scaleAnimation;
    private RotateAnimation rotateAnimation;
    private TranslateAnimation translateAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweenanimation1);
        imageView = (ImageView) findViewById(R.id.imageview);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.alpha:
                alphaAnimation = new AlphaAnimation(0f, 1f);
                alphaAnimation.setDuration(2000);
                imageView.startAnimation(alphaAnimation);
                break;
            case R.id.scale:
                scaleAnimation = new ScaleAnimation(0.5f, 2f, 0.5f, 3f, imageView.getWidth() / 2, imageView.getHeight() / 2);
                scaleAnimation.setDuration(2000);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setRepeatCount(3);
                imageView.startAnimation(scaleAnimation);
                break;
            case R.id.scroll:
                rotateAnimation = new RotateAnimation(20f, 180f, imageView.getWidth() / 2, imageView.getHeight() / 2);
                rotateAnimation.setDuration(2000);
                imageView.startAnimation(rotateAnimation);
                break;
            case R.id.translate:
                translateAnimation = new TranslateAnimation(300, 100, 400, 200);
                translateAnimation.setDuration(2000);
                translateAnimation.setRepeatCount(3);
                translateAnimation.setRepeatMode(Animation.REVERSE);
                imageView.startAnimation(translateAnimation);
                break;
            case R.id.all:
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(2000);
                imageView.startAnimation(animationSet);
                break;
        }
    }
}
