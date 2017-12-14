package com.example.oscar.wallet.DB.Domain;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by oscar on 2/12/2017.
 */

public class Account {
    private int id;
    private String title;
    private BigDecimal amount;
    private String typeAccount;

    private ArrayList<Operation> operations;


    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
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

}
