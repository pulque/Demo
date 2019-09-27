package com.lizheblogs.demo.module.flow;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;

import com.lizheblogs.demo.R;
import com.lizheblogs.demo.bean.MainBean;
import com.lizheblogs.demo.data.TestFlowData;
import com.lizheblogs.demo.databinding.FlowLayoutBinding;
import com.lizheblogs.demo.databinding.ItemFlowBinding;

import java.util.ArrayList;

/**
 * Created by LiZhe on 2019-09-27.
 * com.lizheblogs.demo.module
 */
public class FlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        // 拿到主线程的MessageQueue
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {

            @Override
            public boolean queueIdle() {
                //  在这里去处理你想延时加载的东西
                delayLoad();

                // 最后返回false，后续不用再监听了。
                return false;
            }
        });
    }

    public void delayLoad() {
        NestedScrollView nsView = findViewById(R.id.nsView);

        LayoutInflater inflater = LayoutInflater.from(this);

        FlowLayoutBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.flow_layout,
                        null, false);

        ArrayList<MainBean> testData = TestFlowData.getTestData();
        int size = testData.size();
        int[] d = new int[size];
        for (int i = 0; i < size; i++) {
            ItemFlowBinding bindingItem = DataBindingUtil
                    .inflate(inflater, R.layout.item_flow,
                            null, false);
            bindingItem.setItem(testData.get(i));
            bindingItem.executePendingBindings();
            View root = bindingItem.getRoot();
            d[i] = i + 1000;
            root.setId(d[i]);
            binding.layout.addView(root);
        }
        binding.flowRV.setReferencedIds(d);
        binding.flowRV.updatePreLayout(binding.layout);
        nsView.addView(binding.getRoot());
    }
}
