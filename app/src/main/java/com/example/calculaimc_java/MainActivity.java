package com.example.calculaimc_java;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText nrAltura;
    private EditText nrPeso;

    private TextView nrResultado;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nrAltura = findViewById(R.id.nrAltura);
        nrPeso = findViewById(R.id.nrPeso);

        nrResultado = findViewById(R.id.nrResultado);

        btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btCalcularOnClick();
            }
        });

        btCalcular.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Este é o botão Calular", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }// Fim do metodo onClick

    private void btCalcularOnClick() {

        if (nrPeso.getText().toString().equals("")) {
            Log.e("MainActivity", "Ocorreu um erro no campo Peso.");
            nrPeso.setError("Campo peso deve ser preenchido.");
            return;
        }

        if (nrAltura.getText().toString().equals("")) {
            nrAltura.setError("Campo altura deve ser preenchido.");
            return;
        }

        double altura = Double.parseDouble(nrAltura.getText().toString());
        double peso = Double.parseDouble(nrPeso.getText().toString());

        double resultado = peso / Math.pow(altura, 2);

        DecimalFormat df;
        df = new DecimalFormat("0.00");
        nrResultado.setText(df.format(resultado));
    }

    public void btLimparOnClick(View v) {
        nrAltura.setText("");
        nrPeso.setText("");
        nrResultado.setText("0.0");

        nrPeso.requestFocus();
    }

}// Fim da main