package com.example.ningbaoqi.aniamtion;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;

/**
 * 自定义补间动画，需要继承Animation，继承Animation时关键是要重写该抽象基类的；
 */
public class MyTweenAnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    private DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweenanimation1);
        imageView = (ImageView) findViewById(R.id.imageview);
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
    }

    public void click(View view) {
        imageView.startAnimation(new MyAnimation(displayMetrics.xdpi / 2, displayMetrics.ydpi / 2, 3500));
    }

    class MyAnimation extends Animation {
        private float centerX;
        private float centerY;
        private int duration;
        private Camera camera = new Camera();

        public MyAnimation(float x, float y, int duration) {
            this.centerX = x;
            this.centerY = y;
            this.duration = duration;
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            setDuration(duration);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        /**
         * interpolatedTime : 代表了动画的时间进行比，不管动画实际的持续时间如何，当动画播放时，该参数总是自动从0变化到1
         * Transformation : 代表了补间动画在不同时刻对图形或组件的变形程度，该对象里封装了一个Matrix对象，对它所包装的 Matrix进行位移、倾斜、旋转等变换时，Transformation将会控制对应的图片或视图进行相应的变换
         */
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            camera.save();
            camera.translate(100.0f - 100.0f * interpolatedTime, 150.0f * interpolatedTime - 150.0f, 80.0f * interpolatedTime);
            camera.rotateX(360 * interpolatedTime);
            camera.rotateY(360 * interpolatedTime);
            Matrix matrix = t.getMatrix();
            camera.getMatrix(matrix);
            matrix.preTranslate(-centerX, -centerY);
            matrix.preTranslate(centerX, centerY);
            camera.restore();
        }
    }
}
