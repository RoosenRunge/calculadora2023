package com.example.calculadora2023;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.calculadora2023.R.id.somaXML;

public class Calculadora extends AppCompatActivity {

    //1 criando as variáveis Java associadas os elementos XML do layout
    private EditText opr1;
    private EditText opr2;
    private Button soma;
    private Button sub;
    private Button div;
    private Button mult;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora1);

        //2 associando as variáveis aos correspondentes elementos XML
        opr1 = findViewById(R.id.opr1XML);
        opr2 = findViewById(R.id.opr2XML);
        soma = findViewById(somaXML);
        sub = findViewById(R.id.subXML);
        div = findViewById(R.id.divXML);
        mult = findViewById(R.id.multXML);
        result = findViewById(R.id.resultXML);


//###################inicio do primeiro trecho de código##############################
        //3 Como existem diversos botões, para não ter que criar uma classe anônima para cada um,
        //criaremos uma variável "handler" associada a uma classe anônima e a utilizaremos para os
        //eventos de todos os botões.

        View.OnClickListener handler = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //4 variável para guardar o resultado da operação matemática na calculadora
                int result_in = 0;

                //5 variável que irá capturar qual botão (view) foi acionado
                 int botao = v.getId();

                //6 verfica se os campos dos dois operandos nos EditText não estão vazios
                if (opr1.getText().length() == 0 || opr2.getText().length() == 0) {
                    //7 Se qualquer um deles não estiver preenchido mostra a mensagem pedindo o preenchimento
                    Toast.makeText(Calculadora.this, "por favor preencha os campos",
                            Toast.LENGTH_LONG).show();
                } else {
                    //8 se ok! captura o texto e converte para uma valor inteiro.
                    int oper1_in = Integer.parseInt(opr1.getText().toString());
                    int oper2_in = Integer.parseInt(opr2.getText().toString());

                    //9 vamos colar as operações dentro de um try pois como as variáveis são inteiras
                    //pode ocorre um arithmeticException se for tentado divisão por zero.
                    try {
                        //10 seleção através de switch da variável botão que capturo qual botão foi acionado.

                        if(botao== R.id.somaXML)
                        result_in = oper1_in + oper2_in;
                        else if (botao == R.id.subXML)
                        result_in = oper1_in - oper2_in;
                        else if (botao == R.id.multXML)
                        result_in = oper1_in * oper2_in;
                        else
                        result_in = oper1_in / oper2_in;

                        //11 agora fazemos o caminho contrário=>convertemos o resultado em uma string
                        //e colocamos no TextView
                         result.setText(Integer.toString(result_in));
                    }
                    //se ocorrer uma tentativa de divisão por zero o catch captura a exceção e mostra uma mensagem
                    //na tela para o usuário.
                    catch (ArithmeticException e) {
                        Toast.makeText(Calculadora.this, "o denominador deve ser diferente de zero!",
                                Toast.LENGTH_LONG).show();
                    }

                }
            }
        };

        //3.5 colocando os listeners nos botões e associando ao handler
        soma.setOnClickListener(handler);
        sub.setOnClickListener(handler);
        div.setOnClickListener(handler);
        mult.setOnClickListener(handler);
    }
}
//###################fim ##############################


