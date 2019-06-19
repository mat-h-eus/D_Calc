package com.example.d_calc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {

    private ArrayList<Disciplina> disciplinas;
    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);
    }

    public DisciplinaAdapter(Context context, ArrayList<Disciplina> list)
    {
        disciplinas = list;
        activity = (ItemClicked) context;

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
    public DisciplinaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(disciplinas.get(i));
        viewHolder.tvDisciplina.setTag(disciplinas.get(i).getNome());
    }



    @Override
    public int getItemCount() {
        return disciplinas.size();
    }
}
