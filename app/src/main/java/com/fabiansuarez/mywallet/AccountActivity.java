package com.fabiansuarez.mywallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity {
    private ArrayList<Account> listAccount = new ArrayList<>();
    private AccountAdapter myAccountAdapter;
    private RecyclerView rvListAccount;
    private FloatingActionButton fabAddAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        asociateViewXML();
        loadTestData();
        myAccountAdapter = new AccountAdapter(listAccount);
        myAccountAdapter.setOnClickListener(new AccountAdapter.OnClickListener() {
            @Override
            public void onClickDelete(Account myAccount) {
                Toast.makeText(AccountActivity.this, "eliminar "+myAccount.getName(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onClickEdit(Account myAccount) {
                Toast.makeText(AccountActivity.this, "editar "+myAccount.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        rvListAccount.setAdapter(myAccountAdapter);
        rvListAccount.setLayoutManager(new LinearLayoutManager(AccountActivity.this));
        rvListAccount.setHasFixedSize(true);


        fabAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, NewAccountActivity.class));
            }
        });
    }
    private void asociateViewXML() {
        rvListAccount = findViewById(R.id.rv_accounts);
        fabAddAccount = findViewById(R.id.fab_add_account);
    }
    private void loadTestData() {
        Account myAccount1 =
                new Account("Efectivo", "Efectivo", 1000000.13245, "https://cdn-icons-png.flaticon.com/512/2331/2331941.png");
        Account myAccount2 =
                new Account("Bancolombia", "Efectivo", -1000000.01234, "https://i.pinimg.com/originals/b8/cd/c1/b8cdc1ad498fe080bc21bb5a03c24f83.png");
        Account myAccount3 =
                new Account("Nequi", "Efectivo", -1000000.0, "https://seeklogo.com/images/N/nequi-logo-58FBE82BA6-seeklogo.com.png");
        Account myAccount4 =
                new Account("Davivienda", "Efectivo", 1000000.0, "https://s3.amazonaws.com/lacabinadavivienda.com/projects/assets_generales/img/logo-davivienda.png?v=2");
        Account myAccount5 =
                new Account("Ahorro a la mano", "Efectivo", 1000000.0, "https://www.bancolombia.com/wcm/connect/b8e4c3f2-36a9-497d-a125-ac04f83b0bf8/LogoBancolombia.png?MOD=AJPERES");
        listAccount.add(myAccount1);
        listAccount.add(myAccount2);
        listAccount.add(myAccount3);
        listAccount.add(myAccount4);
        listAccount.add(myAccount5);
    }


}