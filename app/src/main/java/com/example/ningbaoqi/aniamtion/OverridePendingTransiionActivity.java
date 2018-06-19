package com.example.ningbaoqi.aniamtion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OverridePendingTransiionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tra1);
    }

    public void click(View view) {
        startActivity(new Intent(OverridePendingTransiionActivity.this, OverridePendingTransiion2Activity.class));
        finish();
        overridePendingTransition(R.anim.traslate_previous_in, R.anim.translate_previous_out);//该方法必须在startActivity finish 方法之后调用才能生效
    }
}
