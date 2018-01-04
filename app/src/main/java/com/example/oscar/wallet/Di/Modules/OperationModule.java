package com.example.oscar.wallet.Di.Modules;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.OperationInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.OperationPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountNewView;
import com.example.oscar.wallet.Interfaces.InterfacesViews.OperationView;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Models.Operation;
import com.example.oscar.wallet.Presenters.AccountPresenterImpl;
import com.example.oscar.wallet.Presenters.OperationPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oscar on 30/12/2017.
 */

@Module
public class OperationModule {

    private OperationView operationView;

    public OperationModule(OperationView view) {
        this.operationView = view;
    }

    @Provides
    public OperationView provideOperationView(){
        return operationView;
    }

    @Provides
    public OperationPresenter providePresenter(OperationView view, OperationInteractor interactor){
        return new OperationPresenterImpl(view,interactor);
    }

    @Provides
    public Operation provideOperation(){
        return  new Operation();
    }
}
