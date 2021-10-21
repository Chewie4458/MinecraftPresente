package com.curso.minecraftpresente;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.renderscript.RenderScript;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.ref.SoftReference;

public class Senhas extends AppCompatActivity {


    private TextView txtInfo;
    private TextView txtPergunta;

    private EditText edtResp;

    private Button btnEnter;

    //Lista com as perguntas e respostas
    String[] perguntas = {"A única boa do Mestre de Cerimônia que Voa", "Pergunta 2", "Pergunta 3", "Pergunta 4"};
    String[] respostas = {"love is easy", "b", "c", "d"};

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senhas);

        //Vibração do botão
        final Vibrator vibrar = (Vibrator)Senhas.this.getSystemService(Context.VIBRATOR_SERVICE);

        txtInfo = (TextView)findViewById(R.id.txtInfo);
        txtPergunta = (TextView)findViewById(R.id.txtPergunta);

        edtResp = (EditText)findViewById(R.id.edtResp);

        btnEnter = (Button)findViewById(R.id.btnEnter);

        txtPergunta.setText(perguntas[0]);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //vibração
                vibrar.vibrate(55);
                //Checa se chegou no final de todas as perguntas, e libera as informações da conta
                    if(count == perguntas.length-1){
                        if(respostas[count].equals(edtResp.getText().toString().toLowerCase())) {
                            count++;
                            switchActivities();
                        }else{
                            count = perguntas.length-1;
                        }
                    }else{
                        if(respostas[count].equals(edtResp.getText().toString().toLowerCase())){
                            count++;
                            txtPergunta.setText(perguntas[count]);
                            System.out.println(count);
                            edtResp.setText("");
                        }
                        else {

                        }
                    }
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, Final.class);
        startActivity(switchActivityIntent);
    }
}
