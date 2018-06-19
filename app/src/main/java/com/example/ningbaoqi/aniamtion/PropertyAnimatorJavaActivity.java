package com.example.ningbaoqi.aniamtion;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PropertyAnimatorJavaActivity extends AppCompatActivity {
    private ImageView imageView;
    private ObjectAnimator translation;
    private ObjectAnimator scale;
    private ObjectAnimator scroll;
    private ObjectAnimator alpha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweenanimation1);
        imageView = (ImageView) findViewById(R.id.imageview);
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.translate:
                translation = ObjectAnimator.ofFloat(imageView, "translationX", 10f, 70f, 20f, 100f);
                translation.setDuration(2000);
                translation.setRepeatCount(2);
                translation.setRepeatMode(ValueAnimator.RESTART);
                translation.start();
                break;
            case R.id.scale:
                scale = ObjectAnimator.ofFloat(imageView, "scaleX", 1.5f, 0.5f, 2.0f);
                scale.setDuration(2000);
                scale.start();
                break;
            case R.id.alpha:
                alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 0.6f, 0.2f, 1.0f);
                alpha.setDuration(2000);
                alpha.start();
                break;
            case R.id.scroll:
                scroll = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 100, 90, 360);
                scroll.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(PropertyAnimatorJavaActivity.this, "动画开始", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(PropertyAnimatorJavaActivity.this, "动画结束", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                });
                scroll.setDuration(2000);
                scroll.start();
                break;
            case R.id.all:
                AnimatorSet animatorSet = new AnimatorSet();
                //animatorSet.playTogether(alpha, scale, translation, scroll);设置一起播放动画
                animatorSet.playSequentially(alpha, scroll, translation, scale);//动画顺序播放
                animatorSet.start();
                break;
        }
    }
}
