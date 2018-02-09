package com.example.master.calculator;

import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.master.calculator.Listeners.FloatPoint32BitConverter;

public class Main2Activity extends AppCompatActivity {


    private Button convert;
    private TextView sign, mantissa, exponent;
    private EditText UserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        convert = (Button) findViewById(R.id.convert);
        sign = (TextView) findViewById(R.id.sign);
        mantissa = (TextView) findViewById(R.id.Mantissa);
        exponent = (TextView) findViewById(R.id.Exponent);
        UserInput = (EditText) findViewById(R.id.UserInput);

        FloatPoint32BitConverter convertListener = new FloatPoint32BitConverter(sign,
                mantissa, exponent, UserInput);

        convert.setOnClickListener(convertListener);








    }
}
