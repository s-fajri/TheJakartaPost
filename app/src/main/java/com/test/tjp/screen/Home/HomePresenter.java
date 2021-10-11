package com.test.tjp.screen.Home;

import android.app.Application;

import androidx.annotation.Nullable;

import com.test.tjp.data.remote.RemoteRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {

    private Application application;
    private RemoteRepository remoteRepository;
    private CompositeDisposable mDisposable;

    @Nullable
    private HomeContract.View mView;

    @Inject
    HomePresenter(Application application, RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
        this.application = application;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void takeView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void getNewsList(int limit, int skip) {
        mDisposable.add(remoteRepository.getListNews(limit, skip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( newsResponse -> {
                    mView.getNewsComplete(newsResponse.getDatas());
                }, error -> {
                    mView.getNewsError(error.getMessage());
                }

        ));
    }
}
