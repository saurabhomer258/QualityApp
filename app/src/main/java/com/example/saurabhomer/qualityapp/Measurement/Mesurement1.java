package com.example.saurabhomer.qualityapp.Measurement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabhomer.qualityapp.R;

public class Mesurement1 extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesurement1);
        final  EditText edt_hours = findViewById(R.id.edt_hours);
       btn=  (Button)findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edt_hours.getText().toString();
                Intent i = new Intent(Mesurement1.this,Measurment.class);
                i.putExtra("data",data);
                startActivity(i);
            }
        });
    }
}
