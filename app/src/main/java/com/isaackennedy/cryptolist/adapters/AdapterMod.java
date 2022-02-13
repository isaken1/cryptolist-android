package com.isaackennedy.cryptolist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isaackennedy.cryptolist.R;
import com.isaackennedy.cryptolist.model.Moeda;

import java.util.List;

public class AdapterMod extends RecyclerView.Adapter<AdapterMod.MinhaViewHolder> {

    private List<Moeda> listaMoedas;

    public AdapterMod(List<Moeda> lista){
        this.listaMoedas = lista;
    }

    @NonNull
    @Override
    public MinhaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elementoLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_lista_mod,parent,false);
        return new MinhaViewHolder(elementoLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMod.MinhaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaMoedas.size();
    }

    public class MinhaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvNome;
        TextView tvSimbolo;
        TextView tvRank;
        CardView cvItem;

        public MinhaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNome = itemView.findViewById(R.id.tvNomeRV);
            tvSimbolo = itemView.findViewById(R.id.tvSimboloRV);
            tvRank = itemView.findViewById(R.id.tvRankRV);

            cvItem = itemView.findViewById(R.id.cvItem);

            cvItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            
        }
    }


}
