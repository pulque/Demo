package com.lizheblogs.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.lizheblogs.demo.bean.MainBean;
import com.lizheblogs.demo.common.listener.DemoCallback;
import com.lizheblogs.demo.module.flow.FlowActivity;
import com.lizheblogs.demo.module.main.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DemoCallback<MainBean> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = findViewById(R.id.recyclerView);

        MainAdapter adapter = new MainAdapter(this);
        view.setAdapter(adapter);
        List<MainBean> beans = new ArrayList<>();
        beans.add(new MainBean("Flow Layout", "androidx.constraintlayout.helper.widget.Flow", FlowActivity.class));
        adapter.setList(beans);
    }

    @Override
    public void callback(MainBean bean) {
        if (bean != null) {
            Intent intent = new Intent(this, bean.getCls());
            startActivity(intent);
        }
    }
}
