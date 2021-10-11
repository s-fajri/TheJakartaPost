package com.test.tjp.data;

import com.test.tjp.data.remote.RemoteDataSource;
import com.test.tjp.data.remote.RemoteRepository;
import com.test.tjp.data.remote.RemoteService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RepositoryModule {
    @Binds
    abstract RemoteRepository remoteRepository(RemoteDataSource remoteDataSource);

    @Provides
    @Singleton
    static RemoteService remoteService(){
        return new RemoteService();
    }
}
