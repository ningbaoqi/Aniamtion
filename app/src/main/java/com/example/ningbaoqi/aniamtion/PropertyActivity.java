package com.example.ningbaoqi.aniamtion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class PropertyActivity extends AppCompatActivity {
    static final float BALL_SIZE = 50F;
    static final float FULL_TIME = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);
        linearLayout.addView(new MyAnimatorView(this));
    }

    public class MyAnimatorView extends View implements ValueAnimator.AnimatorUpdateListener {
        private final ArrayList<ShapeHolder> balls = new ArrayList<>();

        public MyAnimatorView(Context context) {
            super(context);
            setBackgroundColor(Color.WHITE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            for (ShapeHolder shapeHolder : balls) {
                canvas.save();
                canvas.translate(shapeHolder.getX(), shapeHolder.getY());
                shapeHolder.getShapeDrawable().draw(canvas);
                canvas.restore();
            }
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            this.invalidate();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            ShapeHolder newBall = addBall(event.getRawX(), event.getY());
            float startY = newBall.getY();
            float endY = getHeight() - BALL_SIZE;
            float h = getHeight();
            float eventY = event.getY();
            int duration = (int) (FULL_TIME * (h - eventY) / h);
            ValueAnimator fallAnim = ObjectAnimator.ofFloat(newBall, "y", startY, endY);
            fallAnim.setDuration(duration);
            fallAnim.setInterpolator(new AccelerateDecelerateInterpolator());
            fallAnim.addUpdateListener(this);
            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f, 0f);
            fadeAnim.setDuration(250);
            fadeAnim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    balls.remove(((ObjectAnimator) animation).getTarget());
                }
            });
            fadeAnim.addUpdateListener(this);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(fallAnim).before(fallAnim);
            animatorSet.start();
            this.invalidate();
            return true;
        }

        private ShapeHolder addBall(float x, float y) {
            OvalShape circle = new OvalShape();
            circle.resize(BALL_SIZE, BALL_SIZE);
            ShapeDrawable shapeDrawable = new ShapeDrawable(circle);
            ShapeHolder shapeHolder = new ShapeHolder(shapeDrawable);
            shapeHolder.setX(x - BALL_SIZE / 2);
            shapeHolder.setY(y - BALL_SIZE / 2);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            int color = 0xff000000 + red << 16 | green << 8 | blue;
            Paint paint = shapeDrawable.getPaint();
            int darkColor = 0xff000000 | red / 4 << 16 | green / 4 << 8 | blue << 4;
            RadialGradient gradient = new RadialGradient(37.5f, 12.5f, BALL_SIZE, color, darkColor, Shader.TileMode.CLAMP);
            paint.setShader(gradient);
            shapeHolder.setPaint(paint);
            balls.add(shapeHolder);
            return shapeHolder;
        }
    }

    class ShapeHolder {
        private float x = 0, y = 0;
        private ShapeDrawable shapeDrawable;
        private int color;
        private RadialGradient gradient;
        private float alpha = 1f;
        private Paint paint;

        public ShapeHolder(ShapeDrawable shapeDrawable) {
            this.shapeDrawable = shapeDrawable;
        }

        public float getX() {
            return this.x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public ShapeDrawable getShapeDrawable() {
            return shapeDrawable;
        }

        public void setShapeDrawable(ShapeDrawable shapeDrawable) {
            this.shapeDrawable = shapeDrawable;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public RadialGradient getGradient() {
            return gradient;
        }

        public void setGradient(RadialGradient gradient) {
            this.gradient = gradient;
        }

        public float getAlpha() {
            return alpha;
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
        }

        public Paint getPaint() {
            return paint;
        }

        public void setPaint(Paint paint) {
            this.paint = paint;
        }
    }
}
