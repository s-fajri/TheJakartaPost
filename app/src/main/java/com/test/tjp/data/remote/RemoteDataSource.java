package com.test.tjp.data.remote;

import android.app.Application;

import com.androidnetworking.common.Priority;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.test.tjp.BuildConfig;
import com.test.tjp.data.model.NewsResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataSource implements RemoteRepository {

    private Application application;

    @Inject
    RemoteDataSource(Application application){
        this.application = application;
    }

    @Override
    public Single<NewsResponse> getListNews(int limit, int skip) {
        return Rx2AndroidNetworking.get(BuildConfig.API_URL + "articles/seasia")
                .addHeaders("Content-Type", "application/json")
                .addQueryParameter("limit", String.valueOf(limit))
                .addQueryParameter("skip", String.valueOf(skip))
                .setPriority(Priority.MEDIUM)
                .build()
                .getObjectSingle(NewsResponse.class);
    }

    @Override
    public Single<NewsResponse> getSingleNews(String path) {
        return Rx2AndroidNetworking.get(BuildConfig.API_URL + "article/url")
                .addHeaders("Content-Type", "application/json")
                .addQueryParameter("path", path)
                .setPriority(Priority.MEDIUM)
                .build()
                .getObjectSingle(NewsResponse.class);
    }
}
