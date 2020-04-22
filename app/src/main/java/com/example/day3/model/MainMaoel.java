package com.example.day3.model;

import android.util.Log;

import androidx.cardview.widget.CardView;

import com.example.day3.ApiService;
import com.example.day3.bean.AllData;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMaoel {
    public void getData(final CallBask callBask){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.Api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        apiService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AllData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllData allData) {
                        callBask.onSuccess(allData.getResults());
                        Log.i("1111",allData.getResults().size()+"");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public interface CallBask{
        void onSuccess(List<AllData.ResultsBean> list);
        void onFail();
    }
}
