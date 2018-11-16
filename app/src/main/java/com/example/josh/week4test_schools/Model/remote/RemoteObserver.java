package com.example.josh.week4test_schools.Model.remote;

import com.example.josh.week4test_schools.Model.SchoolResult;
import com.example.josh.week4test_schools.SchoolsCallback;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<List<SchoolResult>> {
    SchoolsCallback callback;

    public RemoteObserver(SchoolsCallback callback) {
        this.callback = callback;
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<SchoolResult> schoolsResultList) {
        callback.onSuccess(schoolsResultList);
    }

    @Override
    public void onError(Throwable e) {
        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}