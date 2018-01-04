package com.example.oscar.wallet.Views;

import android.app.Application;
import android.content.Context;

import com.example.oscar.wallet.Views.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oscar on 16/12/2017.
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides @Singleton
    public Application provideApplication(){
        return app;
    }

    @Provides @Singleton
    public Context provideContext(){
        return app;
    }
}
