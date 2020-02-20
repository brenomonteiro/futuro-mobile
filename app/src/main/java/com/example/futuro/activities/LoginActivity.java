package com.example.futuro.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.futuro.R;
import com.example.futuro.config.ConfiguracaoFirebase;
import com.example.futuro.model.Aluno;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText campoEmail, campoSenha;
    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
    }

    public void logarUsuario(Aluno aluno){
        autenticacao.signInWithEmailAndPassword(
                aluno.getEmail(),aluno.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirTelaPrincipal();
                }else{
                    Toast.makeText(LoginActivity.this,"Erro ao autenticar usuario!",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void validarAutenticacaoUsuario(View view){
        String textoEmail = campoEmail.getText().toString();
        String textoSenha = campoSenha.getText().toString();
        if(!textoEmail.isEmpty()){
            if(!textoSenha.isEmpty()){
                Aluno alunoLogin = new Aluno();
                alunoLogin.setEmail(textoEmail);
                alunoLogin.setSenha(textoSenha);
                logarUsuario(alunoLogin);


            }else{
                Toast.makeText(LoginActivity.this,"Preencha a senha!",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(LoginActivity.this,"Preencha o e-mail!",Toast.LENGTH_SHORT).show();

        }
    }

    public void abrirTelaPrincipal() {

        Intent adicionardActivity = new Intent(this, MainActivity.class);
        startActivity(adicionardActivity);
    }
}
