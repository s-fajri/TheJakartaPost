package com.test.tjp.data.remote;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.gsonparserfactory.GsonParserFactory;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.tjp.BuildConfig;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class RemoteService {

    @Inject
    public RemoteService(){
    }

    public void init(Application application){

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        AndroidNetworking.initialize(application, okHttpClient);
        AndroidNetworking.setParserFactory(new GsonParserFactory(gson));
        if(BuildConfig.DEBUG){
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.HEADERS);
        }
    }

}
