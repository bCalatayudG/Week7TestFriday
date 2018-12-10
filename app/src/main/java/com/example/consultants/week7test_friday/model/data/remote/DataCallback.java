package com.example.consultants.week7test_friday.model.data.remote;

import com.example.consultants.week7test_friday.model.github2.GithubResult;

public interface DataCallback {

    void onSuccess(GithubResult githubResult);

    void onFailure(String error);

}
