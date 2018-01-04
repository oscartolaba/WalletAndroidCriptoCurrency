package com.example.oscar.wallet.Views.Activities;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.oscar.wallet.Di.Components.DaggerOperationComponent;
import com.example.oscar.wallet.Di.Modules.OperationModule;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerCalculatorResult;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerSelectedCategory;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.OperationPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.OperationView;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Models.Category;
import com.example.oscar.wallet.Models.Operation;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Utils.Format;
import com.example.oscar.wallet.Views.App;
import com.example.oscar.wallet.Views.AppComponent;
import com.example.oscar.wallet.Views.Dialogs.CalculatorFragment;
import com.example.oscar.wallet.Views.Dialogs.CategoriesListFragment;
import com.example.oscar.wallet.Views.Dialogs.DatePickerFragment;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;

public class IncomingActivity extends AppCompatActivity implements OperationView,OnListenerCalculatorResult,OnListenerSelectedCategory {

    @BindView(R.id.txt_ammount)
    EditText txtAmmount;

    @BindView(R.id.txt_date)
    EditText txtDate;

    @BindView(R.id.etxt_category)
    EditText etxtCategory;

    private Menu menu;

    @BindView(R.id.spn_account)
    Spinner spnAccounts;

    @Inject
    Operation operation;

    @Inject
     OperationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerOperationComponent.builder()
                .appComponent((AppComponent) App.getApp(this).getAppComponent())
                .operationModule(new OperationModule(this))
                .build()
                .inject(this);
        setContentView(R.layout.activity_incoming);
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
       presenter.getAccounts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_operation,menu);
        this.menu=menu;
        return  true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        return false;
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void setAccountsAdapter(ArrayList<Account> accounts) {
      ArrayAdapter<Account> adapter = new ArrayAdapter<Account>(this,android.R.layout.simple_spinner_dropdown_item,accounts);
      spnAccounts.setAdapter(adapter);
   //   spnAccounts.setSelection(adapter.getPosition(accounts.get(1)));
    }

    @OnClick(R.id.txt_ammount)
    public void showCalculatorFragmentDialog(){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        Fragment prev= getFragmentManager().findFragmentByTag("dialog");
        if(prev != null){
            fragmentTransaction.remove(prev);
        }

        CalculatorFragment calcultatorFragment= new CalculatorFragment();
        calcultatorFragment.show(fragmentTransaction,"dialog");
    }

    @Override
    public void setAmmount(BigDecimal ammount) {
        operation.setAmount(ammount);
        txtAmmount.setText(Format.formatNumberToCurrency(ammount));
    }

    @OnClick(R.id.txt_date)
    public void showDataPickerDialog(){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        DatePickerFragment datePicker=  DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date= Format.formatTwoDigit(day)+"/"+(Format.formatTwoDigit(month+1))+"/"+year;
                txtDate.setText(date);
            }
        });
        datePicker.show(fragmentTransaction,"date");
        }

    @OnClick(R.id.etxt_category)
    public void showCategoriesDialog(){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        Fragment prev= getFragmentManager().findFragmentByTag("categoriesDialog");
        if(prev != null){
            fragmentTransaction.remove(prev);
        }
        CategoriesListFragment categoriesListFragment= new CategoriesListFragment();
        categoriesListFragment.show(fragmentTransaction,"categoriesDialog");
    }

    @Override
    public void setSelectedCategory(Category category) {
        operation.setCategory(category);
        etxtCategory.setText(category.getDescripcion()); ;
    }


   @OnItemSelected(R.id.spn_account)
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         Account account= (Account) adapterView.getSelectedItem();
         operation.setAccount(account);
    }
}
