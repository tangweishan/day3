package com.example.day3.view;

import com.example.day3.bean.AllData;

import java.util.List;

public interface MainView {
    void getData(List<AllData.ResultsBean> list);
    void showToast(String str);
}
