package com.test.tjp.screen.NewsDetail;

import android.app.Application;

import androidx.annotation.Nullable;

import com.test.tjp.data.remote.RemoteRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private Application application;
    private RemoteRepository remoteRepository;
    private CompositeDisposable mDisposable;

    @Nullable
    private NewsDetailContract.View mView;

    @Inject
    NewsDetailPresenter(Application application, RemoteRepository remoteRepository) {
        this.application = application;
        this.remoteRepository = remoteRepository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void takeView(NewsDetailContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void getNewsDetail(String sPath) {
        mDisposable.add(remoteRepository.getSingleNews(sPath)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( response -> {
                    mView.successGetNewsDetail(response.getDatas().get(0));
                }, error -> {
                    mView.failedGetNewsDetail(error.getMessage());
                })
        );
    }
}
