package com.example.consultants.week7test_friday.model.data.remote;

import com.example.consultants.week7test_friday.model.github2.GithubResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RemoteService {

    @GET("/search/repositories")
    Call<GithubResult> getRepositories(@Query("q") String date);

}

