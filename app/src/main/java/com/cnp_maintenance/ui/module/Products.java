package com.cnp_maintenance.ui.module;

import java.io.Serializable;

/**
 * Created by Tamboli on 28-May-18.
 */

public class Products implements Serializable {

    String product_id, name, price, stock, date;

    public Products() {
    }

    public Products(String product_id, String name, String price) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
    }

    public Products(String product_id, String name, String stock, String date) {
        this.product_id = product_id;
        this.name = name;
        this.stock = stock;
        this.date = date;
    }

    public Products(String name, String stock) {
        this.name=name;
        this.stock=stock;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
