package com.example.notasdfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CambiarNota extends AppCompatActivity {
    String [] array_noms;
    int contador;
    int [] array_n1;
    int [] array_n2;
    int [] array_n3;
    int media;
    String nombrenuevo = "";
    String nombreanterior= "";
    boolean find = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_nota);
        Intent recorgerdatos = getIntent();

        array_noms = recorgerdatos.getStringArrayExtra("array_noms");
        array_n1 = recorgerdatos.getIntArrayExtra("array_n1");
        array_n2 = recorgerdatos.getIntArrayExtra("array_n2");
        array_n3 = recorgerdatos.getIntArrayExtra("array_n3");
        contador = recorgerdatos.getIntExtra("contador", 0);
        media = recorgerdatos.getIntExtra("media", 0);

        Button btn_safe = findViewById(R.id.btn_guardarnombrenuevo);

        btn_safe.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                EditText form_txt_cambiarnombrenuevo = findViewById(R.id.ET_notanueva);
                nombrenuevo = form_txt_cambiarnombrenuevo.getText().toString();
                EditText form_txt_cambiarnombre = findViewById(R.id.ET_cambiarnota);
                nombreanterior = form_txt_cambiarnombre.getText().toString();

                for (int i = 0; i<array_noms.length; i++){
                    if(nombreanterior.equals(array_noms[i]) && !find) {
                        find = true;
                        array_noms[i] = nombrenuevo;
                        Toast toast1 = Toast.makeText(getApplicationContext(),"NOM MODIFICAT", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                    if (!find){
                        Toast toast = Toast.makeText(getApplicationContext(),"ERROR, AQUEST NOM NO EXISTEIX", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });




        Button btn_guardar = findViewById(R.id.btn_cambiarnota);
        btn_guardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String nombrealumno = "";
                int evaluacion=0;
                int nota = 0;
                boolean find = false;
                boolean valid = true;

                EditText name = findViewById(R.id.ET_nombrealumno);
                if (!name.getText().toString().equals("")){
                    nombrealumno = name.getText().toString();
                }else{
                    valid = false;
                    Toast toast_a = Toast.makeText(getApplicationContext(),"ERROR, NOM BUIT", Toast.LENGTH_SHORT);
                    toast_a.show();
                }

                EditText evalu = findViewById(R.id.ET_cambiarnotas);
                if (!evalu.getText().toString().equals("")){
                    evaluacion = Integer.parseInt(evalu.getText().toString());
                }else{
                    valid = false;
                    Toast toast_1 = Toast.makeText(getApplicationContext(),"ERROR, EVALUACIÓ BUIDA", Toast.LENGTH_SHORT);
                    toast_1.show();
                }
                if (evaluacion<1 || evaluacion>3){
                    evalu.setError("Evaluació incorrecta!");
                    evalu.setText("");
                }

                EditText nota2 = findViewById(R.id.ET_notanuevas);
                if (!nota2.getText().toString().equals("")){
                    nota = Integer.parseInt(nota2.getText().toString());
                }else{
                    valid = false;
                    Toast toast_1 = Toast.makeText(getApplicationContext(),"ERROR, NOTA BUIDA", Toast.LENGTH_SHORT);
                    toast_1.show();
                }
                if (nota<0 || nota>10){
                    nota2.setError("Nota incorrecta!");
                    nota2 .setText("");
                }

                if (valid == true){
                    for (int i = 0; i < array_noms.length; i++){
                        if (nombrealumno.equals(array_noms[i]) && !find){
                            find = true;
                            if(evaluacion == 1){
                                array_n1[i] = nota;
                            }
                            if(evaluacion == 2){
                                array_n2[i] = nota;
                            }
                            if(evaluacion == 3){
                                array_n3[i] = nota;
                            }
                            Toast toast_val = Toast.makeText(getApplicationContext(),"MODIFICACIÓ VALIDADA", Toast.LENGTH_SHORT);
                            toast_val.show();
                        }
                    }
                }
            }
        });
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
