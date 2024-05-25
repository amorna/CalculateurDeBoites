package com.amorna.calculateurdeboites;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText jour,periode,contenance;
    private TextView nombre;
    private Button btn,reset;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        jour=findViewById(R.id.jour);
        periode=findViewById(R.id.periode);
        contenance=findViewById(R.id.contenance);
        nombre=findViewById(R.id.nombre);
        btn=findViewById(R.id.btn);
        reset=findViewById(R.id.reset);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double j= Double.parseDouble(String.valueOf(jour.getText()));
                int p=Integer.parseInt(String.valueOf(periode.getText()));
                int c=Integer.parseInt(String.valueOf(contenance.getText()));
                double nb1=j*p/c;
                int nb= (int) Math.ceil(nb1);
                nombre.setText(String.valueOf(nb)+" boîtes");

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jour.setText("");
                periode.setText("");
                contenance.setText("");
                nombre.setText("");
            }
        });
    }
}