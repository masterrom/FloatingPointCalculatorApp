package com.example.master.calculator.Listeners;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Master on 08-Feb-18.
 */

public class FloatPoint32BitConverter implements View.OnClickListener {

    private TextView sign,mantissa,exponent,allDisplay;
    private EditText uInput;

    public FloatPoint32BitConverter(TextView sign, TextView mantissa, TextView exponent,
                                    EditText uInput, TextView finDisplay){

        this.sign = sign;
        this.mantissa = mantissa;
        this.exponent = exponent;
        this.uInput = uInput;
        this.allDisplay = finDisplay;

    }


    @Override
    public void onClick(View view) {
        Float number = Float.parseFloat(String.valueOf(this.uInput.getText()));
        int l =(int)Float.floatToRawIntBits(number); // Use this to pull bits of d

        String bin = Integer.toBinaryString(l);


        while (bin.length() < 31) {
            bin = "0" + bin;
        }



        int sign = 0;

        if (number<0) {
            sign = 1;
        }


        String sSign = Integer.toString(sign);
        String sExponent = "" ;
        String sMantissa = "" ;


        sExponent = bin.substring(0,8);
        sMantissa = bin.substring(8);
        if (bin.length() > 31) {
            sExponent = bin.substring(1, 9);
            sMantissa = bin.substring(9);
        }

        int front_num = 1;
        int exponent = 0;

        if (sExponent == "00000000") {
            exponent = 0;
            front_num = 0;
        }else {
            exponent = Integer.parseInt(sExponent,2) - 127;
        }


        if (exponent < -126) {
            front_num = 0;
            exponent = -126;
        }else if (exponent > 127) {
            front_num = 0;
            exponent = 127;
        }

        int mantissa = 0;


        String s = sSign + "[" + sExponent + "]" + sMantissa;
        this.sign.setText("Sign: " + sSign);
        this.exponent.setText("Exponent: " + sExponent);
        this.mantissa.setText("Mantissa: " + sMantissa);
        this.allDisplay.setText(s);

    }
}
