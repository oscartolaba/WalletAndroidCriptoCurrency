package com.example.oscar.wallet.Models;

import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by oscar on 2/12/2017.
 */

public class Account  {
    private int id;
    private String title;
    private BigDecimal amount;



    private ArrayList<Operation> operations;

    public Account() {
    }

    public Account(int id, String title, BigDecimal amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return title;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Account){
            Account account =(Account)o;
            if(account.getTitle().equals(title) && account.getId()==id)
                return true;
        }
        return false;
    }
}
