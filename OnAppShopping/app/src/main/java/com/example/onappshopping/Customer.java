package com.example.onappshopping;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String username;
    private String password;
    private List<String> prodNames = new ArrayList<String>();


    public Customer(int id, String name, String username, String password)
    {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;

    }

    public void addPurchasedProduct(String prodNa)
    {
        this.prodNames.add(prodNa);

    }

    public int getId() {
        return id;
    }
    public String getName() {return name;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public List<String> getPurchasedProducts(){
        return prodNames;
    }


}