package com.example.oscar.wallet.Di.Components;

import com.example.oscar.wallet.Di.ActivityScope;
import com.example.oscar.wallet.Di.Modules.AccountListModule;
import com.example.oscar.wallet.Di.Modules.OperationModule;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.OperationPresenter;
import com.example.oscar.wallet.Models.Operation;
import com.example.oscar.wallet.Views.Activities.AccountListActivity;
import com.example.oscar.wallet.Views.Activities.IncomingActivity;
import com.example.oscar.wallet.Views.AppComponent;

import dagger.Component;

/**
 * Created by oscar on 30/12/2017.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules=OperationModule.class)
public interface OperationComponent {
    void inject(IncomingActivity activity);
    OperationPresenter getPresenter();
    Operation getOperation();
}
