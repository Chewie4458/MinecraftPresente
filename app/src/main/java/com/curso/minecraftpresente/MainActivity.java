package com.curso.minecraftpresente;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import android.os.CountDownTimer;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* pra testar só muda o 'msFaltantes' antes do countdown - só descomenta que tá em 10 seg */

        int diaFinal = 23;
        //a definir
        int horaFinal = 19;
        int minutoFinal = 30;

        int aux = diaFinal;

        int msFaltantes = 0;

        //if só pra poder minimizar
        if(diaFinal == aux) {

            Calendar calendario = Calendar.getInstance();

            //dias
            //pega o dia de hoje
            int diaHoje = calendario.get(Calendar.DAY_OF_MONTH);

            //calculando apenas os dias inteiros
            int diaFaltantes = diaFinal - (diaHoje + 1);

            //dias faltantes em horas
            int horasDias = diaFaltantes * 24;

            //horas hoje
            //pega a hora atual
            int horaAtual = calendario.get(Calendar.HOUR_OF_DAY);
            System.out.println(horaAtual);

            //calcula só as horas inteiras (+1)
            int horasFaltantesDia = 24 - (horaAtual + 1);

            //minutos hoje
            //pega o minuto atual
            int minutoAtual = calendario.get(Calendar.MINUTE);

            //calcula os minutos inteiros faltantes (+1)
            int minutosFaltantesHoje = 60 - (minutoAtual + 1);

            //segundos hoje
            //pega o segundo atual
            int segundoAtual = calendario.get(Calendar.SECOND);

            //calcula os segundos faltantes
            int segundosFaltantesHoje = 60 - segundoAtual;

            //total
            int horasTotal = horasDias + horasFaltantesDia + horaFinal;
            int minutosTotal = minutosFaltantesHoje + minutoFinal;

            //convertendo para milisegundos
            msFaltantes = (horasTotal * 3600000) + (minutosTotal * 60000) + (segundosFaltantesHoje * 1000);

        }

        final TextView txtCountdown = findViewById(R.id.txtCountdown);

        //para testar só mudar aqui (msFaltaltes)
        //msFaltantes = 10000;

        new CountDownTimer(msFaltantes, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {

                //long hour = (millisUntilFinished / 3600000) % 24;
                long hour = (millisUntilFinished / 3600000);

                String hourStr = "" + hour;

                // deixa a hora com dois algarismos
                if(hour < 10){
                    hourStr = "0" + hour;
                }

                long min = (millisUntilFinished / 60000) % 60;

                String minStr = "" + min;

                //deixa o min com dois algarismos
                if(min < 10){
                    minStr = "0" + min;
                }

                long sec = (millisUntilFinished / 1000) % 60;

                String secStr = "" + sec;

                //deixa o sec com dois algarismos
                if(sec < 10){
                    secStr = "0" + sec;
                }

                txtCountdown.setText(hourStr + ":" + minStr + ":" + secStr);

            }

            public void onFinish() {
                txtCountdown.setText("00:00:00");
                switchActivities();
            }

        }.start();

    }

    //muda para outra tela
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, Senhas.class);
        startActivity(switchActivityIntent);
    }

}
