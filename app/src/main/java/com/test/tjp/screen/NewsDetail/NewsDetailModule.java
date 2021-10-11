package com.test.tjp.screen.NewsDetail;

import com.test.tjp.di.ActivityScoped;
import com.test.tjp.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class NewsDetailModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract NewsDetailFragment requestFragmemt();

    @ActivityScoped
    @Binds
    abstract NewsDetailContract.Presenter requestPresenter(NewsDetailPresenter presenter);
}
