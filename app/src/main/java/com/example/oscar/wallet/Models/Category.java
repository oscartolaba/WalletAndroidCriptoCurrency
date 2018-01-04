package com.example.oscar.wallet.Models;

import java.util.ArrayList;

/**
 * Created by oscar on 2/12/2017.
 */

public class Category {

    private int id;
    private String descripcion;

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }

    private String typeCategory;

    private ArrayList<Operation> operations;


    public Category() {
    }

    public Category(String descripcion, String typeCategory) {
        this.descripcion = descripcion;
        this.typeCategory = typeCategory;
    }

    public Category(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

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

    @Override
    public String toString(){
      return getDescripcion();
    }

}
