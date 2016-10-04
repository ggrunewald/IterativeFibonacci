package com.example.thegr.fibonacciiterativo;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityFibo extends AppCompatActivity {

    public TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fibo);

        final Button button = (Button) findViewById(R.id.button_fibo);

        txtresultado = (TextView) findViewById(R.id.text_fibo_result);

        final EditText editindice = (EditText) findViewById(R.id.edit_fibo_index);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                long anterior = 0;
                Log.v("Fibonacci", "element " + i + " = " + anterior);
                long atual = 1;
                i++;
                Log.v("Fibonacci", "element " + i + " = " + atual);

                if(editindice.getText().length() == 0)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Escolha um índice", Toast.LENGTH_SHORT);
                    toast.show();

                    return;
                }
                Log.v("Fibonacci", "TESTE " + editindice.getText().length());
                int max = Integer.parseInt(editindice.getText().toString());

                Debug.startMethodTracing("iterativo"+max);
                iterate(max, atual, anterior, i);
                Debug.stopMethodTracing();
            }
        });
    }
    public void iterate(int max, long atual, long anterior, int i){


        if(max <=0 || max >= 90)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Escolha um índice entre 1 e 89", Toast.LENGTH_SHORT);
            toast.show();

            return;
        }
        else
        {
            if(max == 1)
            {
                txtresultado.setText("O " + "1" + "º elemento é " + "0");
                return;
            }
            if(max == 2)
            {
                txtresultado.setText("O " + "2" + "º elemento é " + "1");
                return;
            }
        }

        for(i = 2; i < max; i++) {
            long aux = atual;
            atual = atual + anterior;
            anterior = aux;
            Log.v("Fibonacci", "element " + i + " = " + atual);
        }

        txtresultado.setText("O " + max + "º elemento é " + atual);
    }
}
