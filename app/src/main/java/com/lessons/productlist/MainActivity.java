package com.lessons.productlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Product> list = new ArrayList<>();
    private ProductListAdapter adapter;
    RecyclerView recyclerView;
    Button button;
    Intent intent;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.listOfProducts);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(linearLayoutManager);

        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String name = data.getStringExtra("name");
        String id = data.getStringExtra("id");
        //Log.d("Error", name);
        list.add(new Product(name, id));
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Нажмите на продукт, чтоб удалить", Toast.LENGTH_LONG).show();

    }

    public void init() {
        adapter = new ProductListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        list.add(new Product("milk", "1"));
        list.add(new Product("meat", "2"));
        list.add(new Product("chicken", "3"));
        Toast.makeText(this, "Нажмите на продукт, чтоб удалить", Toast.LENGTH_LONG).show();



    }
}

