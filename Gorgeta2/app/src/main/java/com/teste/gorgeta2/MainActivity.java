package com.teste.gorgeta2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView porcentagem, gorjeta, valorTotal;
    private SeekBar barProcentagem;
    private EditText valorInicial;
    private double porcentagemNumero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        porcentagem = findViewById(R.id.texPorcentagem);
        gorjeta = findViewById(R.id.textGorjeta);
        valorTotal = findViewById(R.id.textTotal);
        barProcentagem = findViewById(R.id.seekBar);
        valorInicial = findViewById(R.id.valor);

        barProcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagemNumero = progress;
                porcentagem.setText(progress + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void calcular (){

        String valorRecuperado =  valorInicial.getText().toString();
        if (valorRecuperado.equals("") ){
            Toast.makeText(getApplicationContext(),"Digitar um valor", Toast.LENGTH_SHORT).show();}
        else {double valorDigitado = Double.parseDouble( valorRecuperado);
        double valorGorjeta = valorDigitado * (porcentagemNumero/100);
        double total = valorDigitado + valorGorjeta;
        gorjeta.setText("R$" + Math.round(valorGorjeta));
        valorTotal.setText("R$" + Math.round(total));
        }
    }
}