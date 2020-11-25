package com.lessons.productlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;


import java.util.List;

public class SecondActivity extends AppCompatActivity {

    EditText edit_name;
    EditText edit_text_id;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        edit_name = findViewById(R.id.edit_name);
        edit_text_id = findViewById(R.id.edit_text_id);
        button = findViewById(R.id.btnSend);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                String str = edit_text_id.getText().toString();
                String str1 = edit_name.getText().toString();
                intent.putExtra("name", str1);
                intent.putExtra("id", str);
                setResult(1, intent);
                finish();

            }
        });
    }
}




