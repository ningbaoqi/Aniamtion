package com.example.ningbaoqi.aniamtion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LayoutAnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ListView listView = (ListView) findViewById(R.id.listviw);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("dashabi" + i);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        LayoutAnimationController controller = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        listView.setLayoutAnimation(controller);
        listView.startLayoutAnimation();
    }
}
