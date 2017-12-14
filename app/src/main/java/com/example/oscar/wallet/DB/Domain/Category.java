package com.example.oscar.wallet.DB.Domain;

import java.util.ArrayList;

/**
 * Created by oscar on 2/12/2017.
 */

public class Category {

    private int id;
    private String descripcion;
    private ArrayList<Operation> operations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
