package com.xpf.aop_example.click;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xpf.aop_example.R;

public class SingleClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_click);

        TextView tvClick = findViewById(R.id.tvClick);
        tvClick.setOnClickListener(new View.OnClickListener() {
            // 如果需要自定义点击时间间隔，自行传入毫秒值即可
            // @SingleClick(2000)
            @SingleClick
            @Override
            public void onClick(View v) {
                Toast.makeText(SingleClickActivity.this, "我被点击了~", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
