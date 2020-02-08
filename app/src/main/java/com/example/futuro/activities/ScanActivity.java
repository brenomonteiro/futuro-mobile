package com.example.futuro.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.futuro.R;
import com.example.futuro.classes.Frequencia;
import com.example.futuro.classes.Infracao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.Format;
import java.util.Date;

public class ScanActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    ImageView img;
    ImageView imgAtraso;
    ImageView imgSaiuMaisCedo;
    Integer id;

    String infracao = null;
    String status = null;
    /*Query usuarioPesquisa = usuario.orderByKey().limitToLast(3);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

//        referencia.child("pontos").setValue("100");

       // usuarios.child("001").child("frequencia").setValue("testao")



        img =  (ImageView) findViewById(R.id.idPresenca);
        imgAtraso =  (ImageView) findViewById(R.id.idAtraso);
        imgSaiuMaisCedo = (ImageView) findViewById(R.id.idSaiuMaisCedo);
        final Activity activity = this;

        imgAtraso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 1;
                status = "presente";
                infracao = "segundo horario";
                callQrCode(activity);


            }
        });

        imgSaiuMaisCedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 2;
                infracao = "saiu mais cedo";
                callQrCode(activity);


            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 0;
                infracao = null;
                status = "presente";
                callQrCode(activity);


            }
        });
    }


    private  void callQrCode(Activity activity){

        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera scan");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents()!=null){
                if(id == 0){
                    gravaFrequencia(result.getContents(),status,infracao);
                    alert("gravou0");
                }
                else if(id == 1){
                    gravaFrequencia(result.getContents(),status,infracao);
                    gravaFrequenciaComInfracao(result.getContents(),infracao);
                    alert("gravou1");
                }else{
                    gravaFrequenciaComInfracao(result.getContents(),infracao);
                    alert("gravou2");
                }




            }else{
                alert("Scan cancelado");
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void alert(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }

    private void gravaFrequencia(String idUsuario,String status,String infração){
        DatabaseReference usuarios = referencia.child("usuarios");
        DatabaseReference frequencia = usuarios.child("frequencia");


        Date date = new java.util.Date();

        Format formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Format formatterHora = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = formatter.format(new java.util.Date());
        String dataChamada = formatterHora.format(new java.util.Date());

        Frequencia frequenciaObj = new Frequencia();
        frequenciaObj.setAdmResponsavel("Breno Monteiro");
        frequenciaObj.setData(dataChamada);
        frequenciaObj.setInfracao(infracao);
        frequenciaObj.setStatus(status);

        usuarios.child(idUsuario).child("frequencia").child(data).setValue(frequenciaObj);

    }

    private void gravaFrequenciaComInfracao(String idUsuario,String Nomeinfracao){
        DatabaseReference usuarios = referencia.child("usuarios");




        Format formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Format formatterHora = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = formatter.format(new java.util.Date());
        String dataChamada = formatterHora.format(new java.util.Date());


        Infracao infracao = new Infracao();
        infracao.setAdmResponsavel("Breno Monteiro");
        infracao.setInfracao(Nomeinfracao);




        usuarios.child(idUsuario).child("frequencia").child(data).child("infracoes").push().setValue(infracao);

    }

}
