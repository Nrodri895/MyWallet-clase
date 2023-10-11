package com.fabiansuarez.mywallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private ArrayList<Category> listCategories = new ArrayList<>();
    private RecyclerView rvListCategories;
    private FloatingActionButton fabAddCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        loadFakeDataCategories();
        associateViewXML();

        CategoryAdapter myAdapter = new CategoryAdapter(listCategories);


        rvListCategories.setAdapter(myAdapter);
        rvListCategories.setLayoutManager(new LinearLayoutManager(this));


        fabAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewCategoryDialog dialog = new NewCategoryDialog();
                dialog.show(getSupportFragmentManager(), "");
            }
        });
    }

    private void associateViewXML() {
        rvListCategories = findViewById(R.id.rv_categories_list);
        fabAddCategory = findViewById(R.id.fab_add_category);
    }

    private void loadFakeDataCategories() {
        listCategories.add(new Category("Restaurante", "#FF0000", "#FF0000", "https://cdn-icons-png.flaticon.com/512/562/562729.png"));
        listCategories.add(new Category("Gasolina", "#00FF00", "#00FF00", "https://cdn-icons-png.flaticon.com/512/2933/2933939.png"));
        listCategories.add(new Category("Arriendo", "#0000FF", "#0000FF", "https://cdn-icons-png.flaticon.com/512/2558/2558072.png"));
    }

    public void saveCategory(Category newCategory) {

    }
}