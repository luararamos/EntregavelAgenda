package com.example.luara.agendaluaraapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luara.agendaluaraapplication.R;
import com.example.luara.agendaluaraapplication.model.Pessoa;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    // nao esquecer do new ArrayList
    private List<Pessoa> pessoas = new ArrayList<>();

//    public RecyclerViewAdapter(List<Pessoa> pessoas) {
//        this.pessoas = pessoas;
//    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        Pessoa pessoa = pessoas.get(i);
        viewHolder.bind(pessoa);
    }

    @Override
    public int getItemCount() {
        return pessoas.size();
    }

    // para adicinar contato via fragment
    public void addContato(Pessoa pessoa){
        pessoas.add(pessoa);
        notifyItemChanged(getItemCount());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNome;
        TextView txtNumeroTel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtNumeroTel = itemView.findViewById(R.id.txtNumeroTel);

        }
        public void bind(Pessoa pessoa){
            txtNome.setText(pessoa.getNome());
            txtNumeroTel.setText(pessoa.getNumeroTel());
        }
    }

}
