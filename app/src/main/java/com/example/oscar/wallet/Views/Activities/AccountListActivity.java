package com.example.oscar.wallet.Views.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.oscar.wallet.Di.Components.DaggerAccountListComponent;
import com.example.oscar.wallet.Di.Modules.AccountListModule;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountListView;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Views.Adapters.AccountAdapter;
import com.example.oscar.wallet.Views.App;
import com.example.oscar.wallet.Views.AppComponent;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountListActivity extends AppCompatActivity implements AccountListView {

    @BindView(R.id.listview_accounts)
    ListView listViewAccounts;

    @Inject
    AccountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
       DaggerAccountListComponent.builder()
                .appComponent((AppComponent) App.getApp(this).getAppComponent())
                .accountListModule(new AccountListModule(this))
                .build()
                .inject(this);
      presenter.getAccounts();
      listViewAccounts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

          }
      });
    }

    @Override
    public void showThereAreNotAccounts() {

    }

    @Override
    public void showAccounts(ArrayList<Account> accounts) {
        AccountAdapter adapter= new AccountAdapter(this,accounts);
        listViewAccounts.setAdapter(adapter);
    }
}
