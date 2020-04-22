package com.example.day3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.day3.adapter.VpAdapter;
import com.example.day3.bean.AllData;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private Button mFi2;
    private ViewPager mVp2;
    private Toolbar mTo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }

    private void initView() {
        mFi2 = (Button) findViewById(R.id.fi_2);
        mFi2.setOnClickListener(this);
        mTo2 = (Toolbar) findViewById(R.id.To_2);
        mVp2 = (ViewPager) findViewById(R.id.vp_2);
        Intent intent = getIntent();
        ArrayList<AllData.ResultsBean> list = (ArrayList<AllData.ResultsBean>) intent.getSerializableExtra("a");
        setSupportActionBar(mTo2);
        Log.i("222",list.size()+"");
     VpAdapter vpAdapter = new VpAdapter(this);
        vpAdapter.initData(list);
        mVp2.setAdapter(vpAdapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fi_2:

                finish();
                break;
        }
    }
}
