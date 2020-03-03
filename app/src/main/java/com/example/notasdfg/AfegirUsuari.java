package com.example.notasdfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AfegirUsuari extends AppCompatActivity {


    String [] array_noms;
    int contador;
    int [] array_n1;
    int [] array_n2;
    int [] array_n3;
    int media;
    EditText form_txt_nom,form_txt_n1,form_txt_n2,form_txt_n3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_usuari);

        Intent recorgerdatos = getIntent();

        array_noms = recorgerdatos.getStringArrayExtra("array_noms");
        array_n1 = recorgerdatos.getIntArrayExtra("array_n1");
        array_n2 = recorgerdatos.getIntArrayExtra("array_n2");
        array_n3 = recorgerdatos.getIntArrayExtra("array_n3");
        contador = recorgerdatos.getIntExtra("contador", 0);
        media = recorgerdatos.getIntExtra("media", 0);

        Button btn_guardar = findViewById(R.id.btnGuardar);
        form_txt_nom= findViewById(R.id.ET_name);
        form_txt_n1= findViewById(R.id.ET_n1);
        form_txt_n2= findViewById(R.id.ET_n2);
        form_txt_n3= findViewById(R.id.ET_n3);

        btn_guardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                boolean des_ok = botonnegar(v);
                if (des_ok) {
                    EditText form_txt_nom = findViewById(R.id.ET_name);
                    EditText form_txt_n1 = findViewById(R.id.ET_n1);
                    EditText form_txt_n2 = findViewById(R.id.ET_n2);
                    EditText form_txt_n3 = findViewById(R.id.ET_n3);


                    String nom = form_txt_nom.getText().toString();

                    if(!form_txt_n1.getText().toString().equals("")){
                        array_n1[contador] = Integer.parseInt(form_txt_n1.getText().toString());
                    }

                    if(!form_txt_n2.getText().toString().equals("")){
                        array_n2[contador] = Integer.parseInt(form_txt_n2.getText().toString());
                    }

                    if(!form_txt_n3.getText().toString().equals("")){
                        array_n3[contador] = Integer.parseInt(form_txt_n3.getText().toString());
                    }


                    array_noms[contador] = nom;
                    contador++;
                }
            }

        });

    }
    public boolean botonnegar(View v){
        if (validar()){
            Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show();
        }
        return validar();
    }

    public boolean validar(){
            String nombre = form_txt_nom.getText().toString();
            String nota1 = form_txt_n1.getText().toString();
            String nota2 =form_txt_n2.getText().toString();
            String nota3 = form_txt_n3.getText().toString();

            if (nombre.isEmpty()) {
                form_txt_nom.setError("Falta añadir este campo");
                return false;
            }
            if (nota1.isEmpty()) {
                form_txt_n1.setError("Falta añadir este campo");
                return false;
            }else if (Integer.parseInt(nota1)<0 ||Integer.parseInt(nota1)>10){
                form_txt_n1.setError("Nota incorrecta!");
                form_txt_n1.setText("");
            }
            if (nota2.isEmpty()) {
                form_txt_n2.setError("Falta añadir este campo");
                return false;
            }else if (Integer.parseInt(nota2)<0 ||Integer.parseInt(nota2)>10){
                form_txt_n2.setError("Nota incorrecta!");
                form_txt_n2.setText("");
            }
            if (nota3.isEmpty()) {
                form_txt_n3.setError("Falta añadir este campo");
                return false;
            }else if (Integer.parseInt(nota3)<0 ||Integer.parseInt(nota3)>10){
                form_txt_n3.setError("Nota incorrecta!");
                form_txt_n3.setText("");
            }

            return true;
    }


    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("array_noms", array_noms);
        returnIntent.putExtra("array_n1", array_n1);
        returnIntent.putExtra("array_n2", array_n2);
        returnIntent.putExtra("array_n3", array_n3);
        returnIntent.putExtra("contador", contador);
        returnIntent.putExtra("media", media);

        setResult(RESULT_OK, returnIntent);
        finish();
    }


}


