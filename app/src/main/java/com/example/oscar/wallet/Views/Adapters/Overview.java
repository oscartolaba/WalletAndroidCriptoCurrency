package com.example.oscar.wallet.Views.Adapters;

/**
 * Created by oscar on 14/12/2017.
 */

public class Overview {
    private int id;
    private String title;
    private String subtitle;
   private Double amount;

    public Overview(int id, String title, String subtitle, Double amount) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
