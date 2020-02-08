package com.example.futuro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.Format;
import java.time.LocalDateTime;
import java.util.Date;

public class ScanActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    ImageView img;
    String infracao = null;
    String status = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

//        referencia.child("pontos").setValue("100");

       // usuarios.child("001").child("frequencia").setValue("testao")



        img =  (ImageView) findViewById(R.id.idPresenca);
        final Activity activity = this;
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = "presente";

                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Camera scan");
                integrator.setCameraId(0);
                integrator.initiateScan();

            }
        });
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents()!=null){
                gravaFrequencia(result.getContents(),status,infracao);
                alert("gravou");

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
        String data = formatter.format(new java.util.Date());

        Frequencia frequenciaObj = new Frequencia();
        frequenciaObj.setAdmResponsavel("Breno Monteiro");
        frequenciaObj.setData(data);
        frequenciaObj.setInfracao("sem uniforme");
        frequenciaObj.setStatus(status);

        usuarios.child(idUsuario).child("frequencia").child(data).setValue(frequenciaObj);

    }

}
