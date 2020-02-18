package com.example.futuro.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.futuro.R;
import com.example.futuro.model.Aluno;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {
    private EditText campoNome, campoCPF, campoSala;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editTextNome);
        campoCPF = findViewById(R.id.editTextCpf);
        campoSala = findViewById(R.id.editTextSala);

    }
public void cadastrarUsuario(View view){



    }
    public void validarUsuario(View view){
        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usuarios = referencia.child("usuarios");

        String textoNome = campoNome.getText().toString();
        String textoCpf = campoCPF.getText().toString();
        String textoSala = campoSala.getText().toString();

        if(!textoNome.isEmpty()){
            if(!textoCpf.isEmpty()){
                if(!textoSala.isEmpty()){
                    Aluno aluno = new Aluno(textoNome,textoCpf,textoSala);
                    usuarios.push().setValue(aluno);
                    Toast.makeText(CadastroActivity.this,"Aluno Cadastrado com Sucesso!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CadastroActivity.this,"Preencha a sala!",Toast.LENGTH_SHORT).show();

                }
            }else{
                Toast.makeText(CadastroActivity.this,"Preencha o CPF!",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(CadastroActivity.this,"Preencha o nome!",Toast.LENGTH_SHORT).show();

        }

    }
}
