package com.example.josh.week4test_schools.Model.remote;

import com.example.josh.week4test_schools.SchoolsCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchoolsRepository {

    RemoteDataSource remoteDataSource;

    public SchoolsRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getDicksLocations(String venue, final SchoolsCallback callback){

        remoteDataSource.getSchoolResult(venue)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserver(callback));
    }
}
