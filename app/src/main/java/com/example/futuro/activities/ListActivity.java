package com.example.futuro.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.futuro.R;
import com.example.futuro.adapter.AdapterAlunos;
import com.example.futuro.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaContatos;
    private List<Aluno> listaAlunos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerViewListaContatos = findViewById(R.id.recyclerViewListaAlunos);

        //Listagem aluno
        this.criarAlunos();
        //configurar adapter

        AdapterAlunos adapter = new AdapterAlunos(listaAlunos);
        //configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewListaContatos.setLayoutManager(layoutManager);
        recyclerViewListaContatos.setHasFixedSize(true);
        recyclerViewListaContatos.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewListaContatos.setAdapter(adapter);
    }

    public void criarAlunos(){
        Aluno aluno = new Aluno("Breno","01650447647","Poseidon");
        this.listaAlunos.add(aluno);

         aluno = new Aluno("jamily","016504478675","Boo");
        this.listaAlunos.add(aluno);
    }
}
