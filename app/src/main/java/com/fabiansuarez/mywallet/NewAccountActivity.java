package com.fabiansuarez.mywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NewAccountActivity extends AppCompatActivity {

    private TextInputLayout tilNameAccount, tilTypeAccount, tilBalanceInitial;
    private TextInputEditText etNameAccount, etTypeAccount, etBalanceInitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        associateViewXML();
        Log.i("my_info", "Oncreate");
    }

    private void associateViewXML() {
        etNameAccount = findViewById(R.id.et_nombre_cuenta);
        etTypeAccount = findViewById(R.id.et_tipo_cuenta);
        etBalanceInitial = findViewById(R.id.et_balance_initial);
        tilNameAccount = findViewById(R.id.til_name_account);
        tilTypeAccount = findViewById(R.id.til_type_account);
        tilBalanceInitial = findViewById(R.id.til_balance_initial);
    }

    public void clickBack(View view){
        finish();
    }

    public void clickSave(View view) {
        String name = etNameAccount.getText().toString().trim();
        String typeAcconunt = etTypeAccount.getText().toString().trim();
        String txtBalance = etBalanceInitial.getText().toString().trim();

        if (validateInputs(name, typeAcconunt, txtBalance)) {
            startActivity(new Intent(NewAccountActivity.this, AccountActivity.class));


        }


    }

    private boolean validateInputs(String name, String typeAcconunt, String txtBalance) {

        boolean validate = true;
        //validaciones
        if (name.isEmpty()) {
            tilNameAccount.setError(getString(R.string.text_required));
            validate = false;
        } else {
            tilNameAccount.setError(null);
        }
        if (typeAcconunt.isEmpty()) {
            tilTypeAccount.setError(getString(R.string.text_required));
            validate = false;
        } else {
            tilTypeAccount.setError(null);
        }
        if (txtBalance.isEmpty()) {
            tilBalanceInitial.setError(getString(R.string.text_required));
            validate = false;
        } else {
            tilBalanceInitial.setError(null);
        }

        return validate;
    }
}