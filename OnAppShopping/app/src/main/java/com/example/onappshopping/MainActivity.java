package com.example.onappshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public static Products prod[] = new Products[5];
public static Customer cust[] = new Customer[3];
EditText etUser,etPass;
Button btnLog;
public static String customerName;
public static int custIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.edUser);
        etPass = findViewById(R.id.edPass);
        btnLog=findViewById(R.id.btLogin);
        btnLog.setOnClickListener(this);
        prod[0] = new Products(123,"MacBook",1500,"macbook",10);
        prod[1] = new Products(456,"Key board",30,"keyboard",10);
        prod[2] = new Products(799,"RAM",50,"ram",10);
        prod[3] = new Products(741,"Mouse",10,"mouse",10);
        prod[4] = new Products(852,"Printer",90,"printer",10);

        cust[0]= new Customer(123456,"Sara","sarasara","123456");
        cust[1]= new Customer(456799,"John","johnjohn","123456");
        cust[2]= new Customer(741852,"Robert","robertrobert","123456");
    }
    public void onClick(View v)
    {
        String userEntry = etUser.getText().toString();
        String passEntry = etPass.getText().toString();
        int custId = searchUser(cust,userEntry,passEntry);
        if(custId==-1)
            Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
        else{
            int i=findCustomerById(cust,custId);
            custIndex=i;
            customerName=cust[i].getName();
            Intent go = new Intent(this, ShoppingActivity.class);
            startActivity(go);
        }
    }
    public static int searchUser(Customer cust[],String user, String pass)
    {
        int id;
        for (int i =0;i<cust.length;i++)
            if(user.equals(cust[i].getUsername()) && pass.equals(cust[i].getPassword()))
            {id=cust[i].getId();
             return id;}
        return -1;


    }
    public static int findCustomerById(Customer cust[],int custId)
    {
        for(int i=0;i<cust.length;i++)
            if(cust[i].getId()==custId)
                return i;
            return -1;
    }
}
