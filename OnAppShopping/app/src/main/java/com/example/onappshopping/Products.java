package com.example.onappshopping;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private int prodNo;
    private String prodName;
    private String prodImage;
    private double price;
    private int prodStock;
    private List<Integer> prodQuan = new ArrayList<Integer>();

    public Products(int prodNo,String prodName,double price,String prodImage, int prodStock){
        this.prodNo = prodNo;
        this.prodName=prodName;
        this.price=price;
        this.prodImage=prodImage;
        this.prodStock=prodStock;

    }

    public int getProdNo(){
        if(this.prodNo==prodNo)
        return prodNo;
    else
        return 0;
    }
    public String getProdName(){return prodName;}
    public String getProdImage(){return prodImage;}
    public int getProdStock() {return prodStock;}
    public double getPrice(){return price;}
    public void addPurchasedProduct(Integer prodQu)
    {
        this.prodQuan.add(prodQu);

    }


    public void setProdStock(int prodStock) {this.prodStock=prodStock;}
    public List<Integer> getPurchasedQuantity(){
        return prodQuan;
    }
    public String getProdName(int prodNo)
    {
        if(this.prodNo==prodNo)
            return prodName;
        else
            return null;
    }


}
