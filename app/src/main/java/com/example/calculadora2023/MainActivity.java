package com.example.calculadora2023;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //1 criando as variáveis botão para navegar entre as telas
    private Button calcBtc;
    private Button webBtc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associando as variáveis as elementos correspondentes do layout
        calcBtc = findViewById(R.id.calcXML);
        webBtc = findViewById(R.id.webXML);

        //listener/classe anônima para o ocionamento do botão da da calculadora
        calcBtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //criação da intent para chamar a calculadora
                Intent calcIntent = new Intent(MainActivity.this,  Calculadora.class);
                //Intent calcIntent = new Intent("CALCULA");
                //chamando a calculadora
                startActivity(calcIntent);
            }
        });
        //listener/classe anônima para o acionamento do botão do  browser
        webBtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //criação da intent para chamar a calculadora
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ft.unicamp.br/"));
                //criação da intent para chamar a calculadora
                startActivity(webIntent);
            }
        });



    }

}
