package com.example.josh.week4test_schools;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.josh.week4test_schools.Model.RecyclerViewAdapter;
import com.example.josh.week4test_schools.Model.SchoolResult;
import com.example.josh.week4test_schools.Model.remote.RemoteDataSource;
import com.example.josh.week4test_schools.Model.remote.SchoolsRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClicked {
    List<SchoolResult> schoolList;
    public static final String TAG = "_TAG";
    private RecyclerView rvSchools;
    private SchoolsRepository schoolsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RemoteDataSource remoteDataSource = new RemoteDataSource();
        schoolsRepository = new SchoolsRepository(remoteDataSource);

    }


    @Override
    protected void onStart() {
        super.onStart();
        getDicksLocations();
    }

    public void getDicksLocations() {
        schoolsRepository.getDicksLocations("resource", new SchoolsCallback() {
            @Override
            public void onSuccess(List<SchoolResult> schoolResultsList) {
                schoolList = schoolResultsList;
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(schoolResultsList);
                setUpRecyclerView(adapter);
            }

            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: " + error);
            }
        });
    }

    public void setUpRecyclerView(RecyclerViewAdapter recyclerViewAdapter){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvSchools = findViewById(R.id.rvSchools);
        rvSchools.setAdapter(recyclerViewAdapter);
        rvSchools.setLayoutManager(layoutManager);
        recyclerViewAdapter.setOnClick(MainActivity.this);
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(),SchoolInfoActivity.class);
        intent.putExtra("name",schoolList.get(position).getSchoolName());
        getApplicationContext().startActivity(intent);
    }
}
