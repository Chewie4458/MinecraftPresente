package com.curso.minecraftpresente;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.ref.SoftReference;

public class Senhas extends AppCompatActivity {


    private TextView txtInfo;
    private TextView txtSenha;
    private TextView txtPergunta;

    private EditText edtResp;

    private Button btnEnter;

    String[] perguntas = {"Pergunta 1", "Pergunta 2", "Pergunta 3", "Pergunta 4"};
    String[] respostas = {"A", "B", "C", "D"};

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senhas);


        txtInfo = (TextView)findViewById(R.id.txtInfo);
        txtSenha = (TextView)findViewById(R.id.txtSenha);
        txtPergunta = (TextView)findViewById(R.id.txtPergunta);

        edtResp = (EditText)findViewById(R.id.edtResp);

        btnEnter = (Button)findViewById(R.id.btnEnter);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(count == 3){
                    txtPergunta.setVisibility(View.INVISIBLE);
                    txtInfo.setText("Parabéns Gabriel");
                    txtSenha.setVisibility(View.VISIBLE);
                    edtResp.setVisibility(View.INVISIBLE);
                    btnEnter.setVisibility(View.INVISIBLE);
                }
                else{
                    if(respostas[count].equals(edtResp.getText().toString())){
                        count++;
                        txtPergunta.setText(perguntas[count]);
                    }
                }
            }
        });
    }
}
