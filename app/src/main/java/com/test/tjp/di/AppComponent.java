package com.test.tjp.di;

import android.app.Application;

import com.test.tjp.TheJakartaPost;
import com.test.tjp.data.RepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        RepositoryModule.class,
        AndroidSupportInjectionModule.class
})

public interface AppComponent extends AndroidInjector<TheJakartaPost>  {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
