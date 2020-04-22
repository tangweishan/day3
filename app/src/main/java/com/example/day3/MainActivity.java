package com.example.day3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day3.adapter.RecAdapter;
import com.example.day3.bean.AllData;
import com.example.day3.presenter.MainPresenter;
import com.example.day3.view.MainView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private Toolbar mToM;
    private LinearLayout mLinM;
    private NavigationView mNaM;
    private DrawerLayout mDrM;
    private RecyclerView mRecyM;
    private ArrayList<AllData.ResultsBean> beans;
    private boolean a;
    private RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPresenter presenter = new MainPresenter(this);
        presenter.getdata();
        initView();
    }

    private void initView() {
        mToM = (Toolbar) findViewById(R.id.to_m);
        mLinM = (LinearLayout) findViewById(R.id.lin_m);
        mRecyM = (RecyclerView) findViewById(R.id.recy_m);
        mNaM = (NavigationView) findViewById(R.id.na_m);
        mDrM = (DrawerLayout) findViewById(R.id.dr_m);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrM, mToM, R.string.open, R.string.conn);
        mDrM.addDrawerListener(toggle);
        toggle.syncState();
        adapter = new RecAdapter(this);
        mRecyM.setLayoutManager(new LinearLayoutManager(this));
        mRecyM.setAdapter(adapter);
/*        adapter.setOnCilCkList(new RecAdapter.onCilCkList() {
            @Override
            public void onClick(int p) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                ArrayList<AllData.ResultsBean> getlist = (ArrayList<AllData.ResultsBean>) adapter.getlist();
                intent.putExtra("a",getlist);
                startActivity(intent);
            }
        });*/
        mNaM.getHeaderView(0).findViewById(R.id.im_hh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                ArrayList<AllData.ResultsBean> getlist = (ArrayList<AllData.ResultsBean>) adapter.getlist();
                Log.i("33333",getlist.toString());
                intent.putExtra("a",getlist);
                startActivity(intent);
                mDrM.closeDrawers();
            }
        });
    }

    @Override
    public void getData(List<AllData.ResultsBean> list) {

        adapter.RecAdapter(list);

    }

    @Override
    public void showToast(String str) {

    }
}
