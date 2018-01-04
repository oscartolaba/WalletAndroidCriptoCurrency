package com.example.oscar.wallet.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Utils.Format;

import java.util.List;

/**
 * Created by oscar on 20/12/2017.
 */

public class AccountAdapter extends BaseAdapter {
   private  Context context;
   private List<Account> accountList;

    public AccountAdapter(Context context, List<Account> accountList) {
        this.context = context;
        this.accountList = accountList;
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int i) {
        return accountList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return accountList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= LayoutInflater.from(context);
        view=inflater.inflate(R.layout.item_list_account,null);
        TextView txtTitle= (TextView)view.findViewById(R.id.txt_title);
        TextView txtAmmount=(TextView)view.findViewById(R.id.txt_ammount);
        txtTitle.setText(accountList.get(i).getTitle());
        txtAmmount.setText(Format.formatNumberToCurrency(accountList.get(i).getAmount()));
        return view;
    }
}
