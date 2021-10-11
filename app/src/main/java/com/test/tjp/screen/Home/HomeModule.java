package com.test.tjp.screen.Home;

import com.test.tjp.di.ActivityScoped;
import com.test.tjp.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment requestFragmemt();

    @ActivityScoped
    @Binds
    abstract HomeContract.Presenter requestPresenter(HomePresenter presenter);
}
