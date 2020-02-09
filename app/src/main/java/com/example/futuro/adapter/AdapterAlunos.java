package com.example.futuro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futuro.R;
import com.example.futuro.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AdapterAlunos extends RecyclerView.Adapter<AdapterAlunos.MyViewHolder> {

   private List<Aluno> listaAlunos;
    public AdapterAlunos( List<Aluno> listaAlunos ) {

        this.listaAlunos = listaAlunos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista_alunos, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Aluno aluno = listaAlunos.get(position);
        holder.titulo.setText(aluno.getNome());
    holder.genero.setText(aluno.getCpf());
    holder.ano.setText(aluno.getSala());
    }

    @Override
    public int getItemCount() {

        return listaAlunos.size();
    }

    public  class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView ano;
        TextView genero;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }


}
