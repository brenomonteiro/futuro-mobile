package com.example.futuro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futuro.R;
import com.example.futuro.model.Aluno;

import java.util.List;

public class AdapterAlunos extends RecyclerView.Adapter<AdapterAlunos.MyViewHolder> {

   private List<Aluno> lista;
   private Context context;

   public AdapterAlunos( List<Aluno> listaAlunos ) {

        this.lista = listaAlunos;

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
    Aluno aluno = lista.get(position);
    holder.nome.setText(aluno.getNome());
    holder.cpf.setText(aluno.getCpf());
    holder.sala.setText(aluno.getSala());
    }

    @Override
    public int getItemCount() {

        return lista.size();
    }

    public  class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView cpf;
        TextView sala;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNome);
            cpf = itemView.findViewById(R.id.textCpf);
            sala = itemView.findViewById(R.id.textSala);
        }
    }


}
