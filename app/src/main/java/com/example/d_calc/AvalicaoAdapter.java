package com.example.d_calc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class AvalicaoAdapter extends RecyclerView.Adapter<AvalicaoAdapter.ViewHolder> {

    private ArrayList<Avalicao> avalicaos;
    private Context context;
    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);
    }


    public AvalicaoAdapter(Context context, ArrayList<Avalicao> list)
    {
        avalicaos = list;
        activity = (ItemClicked) context;

    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

         final TextView tvNome;
         final TextView tvNota;
         final TextView tvData;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvNome = itemView.findViewById(R.id.tvNome);
            tvNota = itemView.findViewById(R.id.tvNota);
            tvData = itemView.findViewById(R.id.tvData);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(avalicaos.indexOf((Avalicao)itemView.getTag()));
                }
            });

        }
    }


    @NonNull
    @Override
    public AvalicaoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_av,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AvalicaoAdapter.ViewHolder viewHolder, int i) {
        ViewHolder v = (ViewHolder) viewHolder;
        Avalicao d = avalicaos.get(i);
        v.tvNome.setText(d.getNome());
        v.tvData.setText(d.getData());
        v.tvNota.setText(d.getNota());
        Log.d("myTag", d.getNome());
    }

    @Override
    public int getItemCount() {
        return avalicaos.size();
    }
}
