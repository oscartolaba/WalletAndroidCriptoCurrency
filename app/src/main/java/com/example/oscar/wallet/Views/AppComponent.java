package com.example.oscar.wallet.Views;

import android.content.Context;

import com.example.oscar.wallet.Di.Modules.InteractorModule;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.CategoryInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.OperationInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by oscar on 16/12/2017.
 */

@Singleton
@Component(modules ={AppModule.class, InteractorModule.class})
public interface AppComponent {
    Context getContext();
    AccountInteractor getAccountInteractor();
    OperationInteractor getOperationInteractor();
    CategoryInteractor  getCategoryInteractor();
}
