package com.example.oscar.wallet.Views.Dialogs;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.oscar.wallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 */
public class CategoryFragment extends DialogFragment {

    @BindView(R.id.etxt_description)
       EditText etxtDescription;

       @BindView(R.id.btn_cancel)
       Button  btnCancel;

       @BindView(R.id.btn_save)
       Button btnSave;

       @BindView(R.id.btn_delete)
       Button btnDelete;

     public CategoryFragment() {
        // Required empty public constructor
     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btn_cancel)
    public void dismissDialog(){
         dismiss();
    }

    
}
