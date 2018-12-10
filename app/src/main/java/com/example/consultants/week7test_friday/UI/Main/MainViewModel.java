package com.example.consultants.week7test_friday.UI.Main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.consultants.week7test_friday.model.GitRepository;
import com.example.consultants.week7test_friday.model.data.local.LocalDataSource;
import com.example.consultants.week7test_friday.model.data.remote.RemoteDataSource;
import com.example.consultants.week7test_friday.model.github2.GithubResult;

public class MainViewModel extends AndroidViewModel {

    private GitRepository gitRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        gitRepository = new GitRepository(
                new RemoteDataSource(),
                new LocalDataSource());

    }

    public LiveData<GithubResult> getRepos(){
        return gitRepository.getRepos();
    }

}
