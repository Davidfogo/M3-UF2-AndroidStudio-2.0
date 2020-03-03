package com.example.notasdfg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Lista extends AppCompatActivity {

    RecyclerView recyclerView;

    String [] array_noms;
    int [] array_n1;
    int [] array_n2;
    int [] array_n3;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Intent intent = getIntent();
        array_noms = intent.getStringArrayExtra("array_noms");
        array_n1 = intent.getIntArrayExtra("array_n1");
        array_n2 = intent.getIntArrayExtra("array_n2");
        array_n3 = intent.getIntArrayExtra("array_n3");

        contador = intent.getIntExtra("contador", 0);



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, array_noms, array_n1, array_n2, array_n3, contador);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));


    }

}
