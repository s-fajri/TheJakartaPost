package com.test.tjp.data.remote;

import com.test.tjp.data.model.NewsResponse;

import io.reactivex.Single;

public interface RemoteRepository {

    Single<NewsResponse> getListNews(int limit, int skip);

    Single<NewsResponse> getSingleNews(String path);

}
