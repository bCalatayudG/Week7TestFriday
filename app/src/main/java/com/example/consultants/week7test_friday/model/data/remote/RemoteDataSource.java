package com.example.consultants.week7test_friday.model.data.remote;

import android.util.Log;

import com.example.consultants.week7test_friday.model.github2.GithubResult;
import com.example.consultants.week7test_friday.utils.NetworkAPI;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private static final String TAG = RemoteDataSource.class.getSimpleName() + "_TAG";


    public Retrofit createClient () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public RemoteService getGithubRepo() {
        Log.d(TAG, "getGithubRepo: ");
        return createClient().create(RemoteService.class);
    }

    public Call<GithubResult> getRepository(){
        Log.d(TAG, "getRepository: ");
        return getGithubRepo().getRepositories("created:>2008-09-15" );
    }

    public Call<GithubResult> getGithub() {
        Log.d(TAG, "getGithub: ");
        return getGithubRepo().getRepositories("created:>2008-09-15");

    }
}
