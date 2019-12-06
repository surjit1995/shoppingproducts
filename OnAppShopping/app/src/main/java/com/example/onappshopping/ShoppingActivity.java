package com.example.onappshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
TextView welcome;
ListView purchasedProds;
ImageView prodImg;
Spinner prodSpinner;
EditText etQty, etTotal, etPrice;
Button btnOrder,btnhis;
List<String> products = new ArrayList<String>();

public static int pos;
public static int prodNo;
public  static  String prodName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        welcome=findViewById(R.id.tvWelcome);
        prodImg=findViewById(R.id.imageView1);
        prodImg.setImageResource(R.drawable.macbook);
        etPrice = findViewById(R.id.edPrice);
        etQty=findViewById(R.id.edQty);
        etTotal=findViewById(R.id.edTotal);
        prodSpinner=findViewById(R.id.Prodspinner);
        purchasedProds = findViewById(R.id.listhis);
        welcome.setText("Welcome "+MainActivity.customerName);
        for(int i = 0; i<MainActivity.prod.length;i++)
            products.add(MainActivity.prod[i].getProdName());

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,products);
        adapt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        prodSpinner.setAdapter(adapt);

        prodSpinner.setOnItemSelectedListener(this);
        btnOrder=findViewById(R.id.btOrder);
        btnhis = findViewById(R.id.hisbut);
        btnOrder.setOnClickListener(this);
        btnhis.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        pos = i;
        prodNo = MainActivity.prod[i].getProdNo();
        prodName = MainActivity.prod[i].getProdName();
        Double pr = new Double(MainActivity.prod[i].getPrice());
        etPrice.setText(pr.toString());
        String imgName= MainActivity.prod[i].getProdImage();
        int imgId = getResources().getIdentifier(imgName,"drawable",getPackageName());
        prodImg.setImageResource(imgId);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {


            case R.id.btOrder:

                if (etQty.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter the quantity", Toast.LENGTH_LONG).show();
                else {
                    int qty = Integer.parseInt(etQty.getText().toString());
                    if (MainActivity.prod[pos].getProdStock() >= qty) {
                        double pr = Double.parseDouble(etPrice.getText().toString());
                        Double total = new Double(qty * pr * 1.13);
                        etTotal.setText(total.toString());
                        int stock = MainActivity.prod[pos].getProdStock() - qty;
                        MainActivity.prod[pos].setProdStock(stock);
                        MainActivity.cust[MainActivity.custIndex].addPurchasedProduct(prodName);
                    }

            else
                    Toast.makeText(getApplicationContext(), "Sorry, insufficient stock", Toast.LENGTH_LONG).show();
                }
break;
            case R.id.hisbut:
                List<String> purchased = new ArrayList<String>(MainActivity.cust[MainActivity.custIndex].getPurchasedProducts());
               ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,purchased);
               purchasedProds.setAdapter(adapter);
                break;

        }
    }
}
