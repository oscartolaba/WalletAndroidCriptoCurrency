package com.example.oscar.wallet.Views.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.oscar.wallet.Di.Components.DaggerAccountComponent;
import com.example.oscar.wallet.Di.Modules.AccountModule;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Models.Account;

import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountNewView;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerCalculatorResult;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Utils.Format;
import com.example.oscar.wallet.Views.App;
import com.example.oscar.wallet.Views.AppComponent;
import com.example.oscar.wallet.Views.Dialogs.CalculatorFragment;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountNewActivity extends AppCompatActivity implements AccountNewView,OnListenerCalculatorResult{

    public Menu menu;

    @BindView(R.id.txt_ammount)
    EditText txtAmmount;

    @BindView(R.id.txt_title)
    EditText txtTitle;

     @BindView(R.id.fab)
     FloatingActionButton fabSave;

     @Inject
     Account account;


     @BindView(R.id.app_bar)
     AppBarLayout appBarLayout;

    @Inject
    AccountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerAccountComponent.builder()
                .appComponent((AppComponent) App.getApp(this).getAppComponent())
                .accountModule(new AccountModule(this))
                .build()
                .inject(this);

        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        //AppBarLayout
        AppBarLayout appBarLayout =(AppBarLayout)findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(menu != null){
                MenuItem settingItem= menu.findItem(R.id.action_save);

                    //Collapsed
                if(Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()){
                  settingItem.setVisible(true);

                }else
                {
                    //Expanded
                  if(verticalOffset == 0){
                      settingItem.setVisible(false);

                  }
                }}
            }
        });
     }

    //mostrar dialogo para insertar monto inicial de la cuenta
    public void showCalculatorFragmentDialog(View v){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        Fragment prev= getFragmentManager().findFragmentByTag("dialog");
        if(prev != null){
            fragmentTransaction.remove(prev);
        }

        CalculatorFragment calcultatorFragment= new CalculatorFragment();
        calcultatorFragment.show(fragmentTransaction,"dialog");
    }

    //crear menu para poder selecccionar foto, abrir camarar y guardar cuenta
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_account,menu);
       this.menu=menu;
       return  true;
    }

    //guardar cuenta en base de datos sqlite
     @OnClick(R.id.fab)
     public void saveAccount(){
        account.setTitle(txtTitle.getText().toString());
        presenter.insertAccount(account);
     }


     //mostrar error de monto en pantalla
    @Override
    public void setErrorAmount() {
        txtAmmount.setError("Ingrese monto inicial");
    }


    //mostrar error de titulo
    @Override
    public void setErrorTitle() {
          txtTitle.setError("Ingrese titulo");
    }

    @Override
    public void navigateToHome() {
         Intent intent= new Intent(this,HomeActivity.class);
         startActivity(intent);
    }

    @Override
    public void setErrorTitleVeryShort() {
        txtTitle.setError("Titulo muy corto");
    }

    @Override
    public void setAmmount(BigDecimal ammount) {
         account.setAmount(ammount);
         txtAmmount.setText(Format.formatNumberToCurrency(ammount));
    }


    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
