package com.example.shitagain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cuenta extends AppCompatActivity {
    Button btnpago;
    TextView txtfin;
 //   public static Integer chi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        txtfin=findViewById(R.id.txtfin);
        btnpago=findViewById(R.id.btnpago);
        btnpago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // txtfin.setText(Bebidas.orden);
               // txtfin.setText("Precio:$"+chi.toString());
               // chi=chi+Bebidas.total;

            }
        });


    }

}