package com.test.tjp.di;

import com.test.tjp.screen.Home.HomeActivity;
import com.test.tjp.screen.Home.HomeModule;
import com.test.tjp.screen.NewsDetail.NewsDetailActivity;
import com.test.tjp.screen.NewsDetail.NewsDetailModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = NewsDetailModule.class)
    abstract NewsDetailActivity newsDetailActivity();

}
