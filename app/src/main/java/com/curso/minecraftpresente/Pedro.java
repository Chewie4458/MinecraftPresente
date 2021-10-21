package com.curso.minecraftpresente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class Pedro extends AppCompatActivity {

    private Button btnSite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);

        //Vibração do botão
        final Vibrator vibrar = (Vibrator) Pedro.this.getSystemService(Context.VIBRATOR_SERVICE);

        btnSite = (Button)findViewById(R.id.btnSite);

        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vibra
                vibrar.vibrate(55);
                //Abre o site
                Uri uri = Uri.parse("http://www.minecraft.net");
                Intent openSite = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(openSite);
            }
        });
    }
}