package com.example.futuro.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.futuro.R;
import com.example.futuro.adapter.AdapterAlunos;
import com.example.futuro.config.ConfiguracaoFirebase;
import com.example.futuro.model.Aluno;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaContatos;
    //private ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private List<Aluno> listaAlunos = new ArrayList<>();
    private DatabaseReference usuariosRef;
    private ValueEventListener valueEventListenerContatos;
    private AdapterAlunos adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerViewListaContatos = findViewById(R.id.recyclerViewListaAlunos);
        usuariosRef = ConfiguracaoFirebase.getFirebaseDatabase().child("usuarios");




        //configurar adapter
   //this.criarAlunos();
        this.recuperarContatos();
         adapter = new AdapterAlunos(listaAlunos);
        //configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewListaContatos.setLayoutManager(layoutManager);
        recyclerViewListaContatos.setHasFixedSize(true);
        recyclerViewListaContatos.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewListaContatos.setAdapter(adapter);

    }

//    @Override
//public void onStart(){
//        super.onStart();
//        recuperarContatos();
//}
    @Override
    public void  onStop(){
        super.onStop();
        usuariosRef.removeEventListener(valueEventListenerContatos);
    }

    public void recuperarContatos(){
        valueEventListenerContatos = usuariosRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    Aluno aluno = dados.getValue(Aluno.class);
                    listaAlunos.add(aluno);
                    Log.i("Dados",listaAlunos.toString());
                }
                Log.i("Dados",listaAlunos.toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




}

    public void criarAlunos(){
        Aluno aluno = new Aluno("breno","098765432","poseidom");
        this.listaAlunos.add(aluno);
    }

}
