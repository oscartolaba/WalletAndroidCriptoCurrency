package com.example.oscar.wallet.Di.Modules;

import android.content.Context;

import com.example.oscar.wallet.Interactors.AccountInteractorImpl;
import com.example.oscar.wallet.Interactors.CategoryInteractorImpl;
import com.example.oscar.wallet.Interactors.OperationInteractorImpl;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.CategoryInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.OperationInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishAccount;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oscar on 16/12/2017.
 */
@Module
public class InteractorModule {

    @Provides
    public AccountInteractor provideAccountInteractor(){
        return new AccountInteractorImpl();
    }

    @Provides
    public OperationInteractor provideOperationInteractor(){
        return  new OperationInteractorImpl();
    }
    @Provides
    public CategoryInteractor provideCategoryInteractor(){
        return  new CategoryInteractorImpl();
    }

}
