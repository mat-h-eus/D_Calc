package com.example.d_calc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class AvalicaoAdapter extends RecyclerView.Adapter {

    private ArrayList<Avalicao> avalicaos;


    public AvalicaoAdapter(Context context, ArrayList<Avalicao> list)
    {
        avalicaos = list;
        //activity = (ItemClicked) context;

    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView tvDisciplina;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvDisciplina = itemView.findViewById(R.id.tvDisciplina);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(disciplinas.indexOf((Disciplina)itemView.getTag()));
                }
            });

        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
