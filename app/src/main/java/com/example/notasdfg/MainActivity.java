package com.example.notasdfg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    String [] array_noms = new String [50];
    int [] array_n1 = new int [50];
    int [] array_n2 = new int [50];
    int [] array_n3 = new int [50];
    int contador = 0;
    float media=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button2 = findViewById(R.id.btn_afegir);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                gotoafegirusuari();
            }
        });

        final Button button3 = findViewById(R.id.btn_mostrar);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                gotomostrarusuario();
            }
        });

        final Button button5 = findViewById(R.id.btn_ajuda);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                gotoayuda();
            }
        });

        final Button button_cambiarnota = findViewById(R.id.btn_cambiarnota);
        button_cambiarnota.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                gotocambiarnota();
            }
        });

        final Button button_aprobar = findViewById(R.id.btn_aprobar);
        button_aprobar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                for (int i=0;i< contador;i++){
                    if (array_n1[i]<5){
                        array_n1[i] = 5;
                    }
                    if (array_n2[i]<5) {
                        array_n2[i] = 5;
                    }
                    if (array_n3[i]<5){
                        array_n3[i] = 5;
                    }

                }
            }
        });

        final Button btn_netejarLlista = findViewById(R.id.btn_netejarLlista);
        btn_netejarLlista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                for(int i = 0; i<contador; i++){
                    array_n1[i] = 0;
                    array_n2[i] = 0;
                    array_n3[i] = 0;
                    array_noms[i] = "";
                }

                contador = 0;

                Log.i("borrar", array_noms[0]);
            }
        });
    }
    private void gotocambiarnota(){

        Intent intent_mostrar = new Intent(this, CambiarNota.class);
        intent_mostrar.putExtra("array_noms", array_noms);
        intent_mostrar.putExtra("array_n1", array_n1);
        intent_mostrar.putExtra("array_n2", array_n2);
        intent_mostrar.putExtra("array_n3", array_n3);
        intent_mostrar.putExtra("contador", contador);
        startActivityForResult(intent_mostrar,1);

    }
    private void gotoayuda(){

        Intent intent_mostrar = new Intent(this, Ayuda.class);
        intent_mostrar.putExtra("array_noms", array_noms);
        intent_mostrar.putExtra("array_n1", array_n1);
        intent_mostrar.putExtra("array_n2", array_n2);
        intent_mostrar.putExtra("array_n3", array_n3);
        intent_mostrar.putExtra("contador", contador);
        startActivityForResult(intent_mostrar,1);

    }
    private void gotomostrarusuario(){

        Intent intent_mostrar = new Intent(this, Lista.class);
        intent_mostrar.putExtra("array_noms", array_noms);
        intent_mostrar.putExtra("array_n1", array_n1);
        intent_mostrar.putExtra("array_n2", array_n2);
        intent_mostrar.putExtra("array_n3", array_n3);
        intent_mostrar.putExtra("contador", contador);
        startActivityForResult(intent_mostrar,1);

    }

    private void gotoafegirusuari(){
        /* */
        Intent intent_enviar = new Intent(this, AfegirUsuari.class);
        intent_enviar.putExtra("array_noms", array_noms);
        intent_enviar.putExtra("array_n1", array_n1);
        intent_enviar.putExtra("array_n2", array_n2);
        intent_enviar.putExtra("array_n3", array_n3);
        intent_enviar.putExtra("contador", contador);
        intent_enviar.putExtra("media", media);
        startActivityForResult(intent_enviar,1);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                array_noms = data.getStringArrayExtra("array_noms");
                array_n1 = data.getIntArrayExtra("array_n1");
                array_n2 = data.getIntArrayExtra("array_n2");
                array_n3 = data.getIntArrayExtra("array_n3");
                contador = data.getIntExtra("contador", contador);
                media = data.getFloatExtra("media",  media);
            }
        }
    }

}
