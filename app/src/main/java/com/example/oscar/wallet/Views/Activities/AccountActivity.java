package com.example.oscar.wallet.Views.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.oscar.wallet.Interfaces.AccountView;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Views.Dialogs.CalculatorFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity implements AccountView, CalculatorFragment.OnFragmentInteractionListener {
    public Menu menu;

    @BindView(R.id.spinner_account_type)
      Spinner spinnerAccountsType;

    @BindView(R.id.txt_ammount)
       EditText txtAmmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                MenuItem photoItem= menu.findItem(R.id.action_photo);
                MenuItem cameraItem= menu.findItem(R.id.action_camera);
                    //Collapsed
                if(Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()){
                  settingItem.setVisible(true);
                  photoItem.setVisible(false);
                  cameraItem.setVisible(false);
                }else
                {
                    //Expanded
                  if(verticalOffset == 0){
                      settingItem.setVisible(false);
                      photoItem.setVisible(true);
                      cameraItem.setVisible(true);
                  }
                }}
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        loadSpinnerTypeAccount();
    }

    //cargar spinner de tipos de cuentas
    private void loadSpinnerTypeAccount(){
            String[] listTypeAccounts = getResources().getStringArray(R.array.type_accounts);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listTypeAccounts);
            spinnerAccountsType.setAdapter(adapter);
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


    @Override
    public void setErrorAmount() {

    }

    @Override
    public void setErrorTitle() {

    }

    @Override
    public void navigateToHome() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
