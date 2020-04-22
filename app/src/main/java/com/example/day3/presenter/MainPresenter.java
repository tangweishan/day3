package com.example.day3.presenter;

import com.example.day3.bean.AllData;
import com.example.day3.model.MainMaoel;
import com.example.day3.view.MainView;

import java.util.List;

public class MainPresenter implements MainMaoel.CallBask {
    private MainMaoel mainMaoel;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
         mainMaoel = new MainMaoel();
    }
    public void getdata(){
        mainMaoel.getData(this);
    }
    @Override
    public void onSuccess(List<AllData.ResultsBean> list) {
        if (mainMaoel!=null)
            mainView.getData(list);
    }

    @Override
    public void onFail() {

    }
}
