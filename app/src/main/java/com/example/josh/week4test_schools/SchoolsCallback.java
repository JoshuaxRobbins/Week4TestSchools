package com.example.josh.week4test_schools;

import com.example.josh.week4test_schools.Model.SchoolResult;

import java.util.List;

public interface SchoolsCallback {

    void onSuccess(List<SchoolResult> schoolResultsList);
    void onFailure(String error);

}
