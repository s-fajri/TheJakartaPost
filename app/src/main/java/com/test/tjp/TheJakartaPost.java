package com.test.tjp;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.webkit.WebView;

import com.test.tjp.data.remote.RemoteService;
import com.test.tjp.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class TheJakartaPost extends DaggerApplication {

    @Inject
    RemoteService remoteService;

    @Override
    public void onCreate() {
        super.onCreate();
        remoteService.init(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

}
