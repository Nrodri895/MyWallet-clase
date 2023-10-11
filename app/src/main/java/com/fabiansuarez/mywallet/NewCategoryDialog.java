package com.fabiansuarez.mywallet;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputLayout;

import yuku.ambilwarna.AmbilWarnaDialog;

public class NewCategoryDialog extends DialogFragment {

    private EditText editTitleName;
    private TextInputLayout tilNameNewCategory;
    private Button btnColor, btnCancel, btnOK;
    private String name, color;
    private TextView txtMsgColorInput;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_new_category, null);
        editTitleName = dialogView.findViewById(R.id.et_name_new_category);
        btnColor = dialogView.findViewById(R.id.btn_color_new_category);
        btnCancel = dialogView.findViewById(R.id.btnCancel);
        btnOK = dialogView.findViewById(R.id.btnOK);
        tilNameNewCategory = dialogView.findViewById(R.id.til_name_new_category);
        txtMsgColorInput = dialogView.findViewById(R.id.tv_msg_input_color_new_category);


        builder.setView(dialogView).setMessage(R.string.text_new_category);
// Handle the cancel button
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AmbilWarnaDialog dialog = new AmbilWarnaDialog(v.getContext(), Color.RED, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        btnColor.setBackgroundColor(color);
                        btnColor.setText(String.format("#%06X", color & 0x00FFFFFF));
                    }
                });
                dialog.show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = editTitleName.getText().toString().trim();
                color = btnColor.getText().toString();

                if (validateInputs(name, color)) {
                    /*Category newCategory = new Category(name, color);
                    CategoryActivity categoryActivity = new CategoryActivity();
                    categoryActivity.saveCategory(newCategory);*/
                    dismiss();
                }
            }
        });
        return builder.create();
    }

    private boolean validateInputs(String name, String color) {

        boolean validate = true;
        //validaciones
        if (name.isEmpty()) {
            tilNameNewCategory.setError(getString(R.string.text_required));
            validate = false;
        } else {
            tilNameNewCategory.setError(null);
        }
        if (color.isEmpty() || color.equals("Color")) {
            txtMsgColorInput.setVisibility(View.VISIBLE);
            txtMsgColorInput.setText(getString(R.string.text_required));
            validate = false;
        } else {
            txtMsgColorInput.setVisibility(View.INVISIBLE);
            txtMsgColorInput.setText(getString(R.string.text_required));
        }

        return validate;
    }
}
