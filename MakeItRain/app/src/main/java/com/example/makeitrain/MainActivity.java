package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

   //private Button showTag;
   // private Button showMoney;
    private int moneyCounter = 0;
    private TextView moneyText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyText = findViewById(R.id.moneyText);
       /* showMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MYTAG", "onClick: SHOWMONEY");
            }
        });*/
    }

    public void showTag(View v){
        //Log.d("MYTAG", "onClick: SHOWTAG");
        Toast.makeText(getApplicationContext(),"Hello there",Toast.LENGTH_SHORT).show();
    }

    public void MakeItRain(View v){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        switch(moneyCounter) {
            case 20000: moneyText.setTextColor(Color.parseColor("#FF0000"));
                        Toast.makeText(getApplicationContext(),"Woah you're getting Richer !",Toast.LENGTH_SHORT).show();
                        break;
            case 40000: moneyText.setTextColor(Color.BLACK);
                        Toast.makeText(getApplicationContext(),"Damn you're getting Richer !",Toast.LENGTH_SHORT).show();
                        break;
            case 60000: moneyText.setTextColor(Color.YELLOW);
                        Toast.makeText(getApplicationContext(),"Please stop this is way too much !",Toast.LENGTH_SHORT).show();
                        break;
            default: break;
        }

        moneyText.setText(String.valueOf(numberFormat.format(moneyCounter)));
        //Toast.makeText(getApplicationContext(),"You are $1000 Richer !",Toast.LENGTH_SHORT).show();
        //Log.d("MIR", "onClick: MAKEITRAINBUTTON tapped : "+ moneyCounter);
    }

    public void Reset(View v){
        moneyCounter = 0;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyText.setTextColor(Color.parseColor("#6200EE"));
        moneyText.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Toast.makeText(getApplicationContext(),"Reset",Toast.LENGTH_SHORT).show();
    }
}