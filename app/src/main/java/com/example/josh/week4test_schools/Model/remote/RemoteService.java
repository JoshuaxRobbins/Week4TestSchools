package com.example.josh.week4test_schools.Model.remote;

import com.example.josh.week4test_schools.Model.SchoolResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RemoteService {

    @GET("{resource}/97mf-9njv.json")
    Observable<List<SchoolResult>> getSchoolList(@Path("resource") String resource);
}
