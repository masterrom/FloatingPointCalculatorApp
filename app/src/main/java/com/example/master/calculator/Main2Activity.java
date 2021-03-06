package com.example.master.calculator;

import android.os.Build;
import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.master.calculator.Listeners.FloatPoint32BitConverter;

public class Main2Activity extends AppCompatActivity {


    private Button convert;
    private TextView sign, mantissa, exponent, allDisplay;
    private EditText UserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        convert = (Button) findViewById(R.id.convert);
        sign = (TextView) findViewById(R.id.sign);
        mantissa = (TextView) findViewById(R.id.Mantissa);
        exponent = (TextView) findViewById(R.id.Exponent);
        UserInput = (EditText) findViewById(R.id.UserInput);
        allDisplay = (TextView)  findViewById(R.id.allTogether);


        FloatPoint32BitConverter convertListener = new FloatPoint32BitConverter(sign,
                mantissa, exponent, UserInput, allDisplay);

        convert.setOnClickListener(convertListener);








    }
}
