package com.example.ningbaoqi.aniamtion;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * 帧动画：它要求开发者把动画过程的每张静态图片都收集起来，然后由Android来控制依次显示这些静态图片，
 * 再利用人眼视觉残留的原理，给用户造成动画的错觉；android:oneshot 控制该动画是否循环播放 如果该参数指定为true，
 * 则动画将不会循环播放，否则该动画将会循环播放，每个item子元素添加一帧;
 */
public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frameanimation);
    }

    public void start(View view) {
        imageView = (ImageView) findViewById(R.id.imageview);
        imageView.setBackgroundResource(R.drawable.frameanimation);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();
    }
}
