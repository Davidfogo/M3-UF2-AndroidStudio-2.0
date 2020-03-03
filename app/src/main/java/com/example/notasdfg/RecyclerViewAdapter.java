package com.example.notasdfg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private String [] array_noms;
    int [] array_n1;
    int [] array_n2;
    int [] array_n3;
    int contador = 0;

    private Context context;


    public RecyclerViewAdapter(Context con, String[] arrN, int[] arr_n1, int[] arr_n2, int[] arr_n3, int cont){
        array_noms = arrN;
        array_n1 = arr_n1;
        array_n2 = arr_n2;
        array_n3 = arr_n3;
        contador = cont;
        context = con;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(array_noms[position]!="0"){
            holder.etiquetaNom.setText(array_noms[position]);
            holder.text_nota1.setText(Integer.toString(array_n1[position]));
            holder.text_nota2.setText(Integer.toString(array_n2[position]));
            holder.text_nota3.setText(Integer.toString(array_n3[position]));

            float media = (array_n1[position]+array_n2[position]+array_n3[position])/3;
            holder.text_media.setText(String.valueOf(media));
        }

    }

    @Override
    public int getItemCount() {
        return contador;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView etiquetaNom;
        TextView text_nota1;
        TextView text_nota2;
        TextView text_nota3;
        TextView text_media;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userName);
            text_nota1 = itemView.findViewById(R.id.text_nota1);
            text_nota2 = itemView.findViewById(R.id.text_nota2);
            text_nota3 = itemView.findViewById(R.id.text_nota3);
            text_media = itemView.findViewById(R.id.text_media);
            layout = itemView.findViewById(R.id.layout);
        }
    }



}
