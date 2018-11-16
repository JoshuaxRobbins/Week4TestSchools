package com.example.josh.week4test_schools.Model.remote;

import com.example.josh.week4test_schools.Model.SchoolResult;
import com.example.josh.week4test_schools.Model.remote.Utils.NetworkHelper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createInstance(){
        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private RemoteService getRemoteService(){
        return createInstance().create(RemoteService.class);
    }

    public Observable<List<SchoolResult>> getSchoolResult(String resource){
        return getRemoteService().getSchoolList(resource);
    }
}