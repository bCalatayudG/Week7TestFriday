package com.example.consultants.week7test_friday.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.consultants.week7test_friday.model.data.local.LocalDataSource;
import com.example.consultants.week7test_friday.model.data.remote.RemoteDataSource;
import com.example.consultants.week7test_friday.model.github2.GithubResult;
import com.example.consultants.week7test_friday.model.github2.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitRepository {

    MutableLiveData<GithubResult> listLiveData;
    RemoteDataSource remoteDataSource;
    LocalDataSource localDataSource;

    private static final String TAG = GitRepository.class.getSimpleName() + "_TAG";


    public GitRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;

        listLiveData = new MutableLiveData<>();
    }


    public LiveData<GithubResult> getRepos() {
        Log.d(TAG, "getRepos: ");
        final List<Item> githubResultList = new ArrayList<>();
        remoteDataSource.getGithub().enqueue(new Callback<GithubResult>() {
            @Override
            public void onResponse(Call<GithubResult> call, Response<GithubResult> response) {
                Log.d(TAG, "onResponse: " + response.body().getItems().get(0).getDescription());
                listLiveData.setValue(response.body());
                githubResultList.set(0,response.body().getItems().get(0));
            }

            @Override
            public void onFailure(Call<GithubResult> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listLiveData;
    }

}
