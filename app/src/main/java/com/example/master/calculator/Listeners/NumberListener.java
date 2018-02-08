package com.example.master.calculator.Listeners;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Master on 25-Dec-17.
 */

public class NumberListener implements View.OnClickListener {

    private TextView view;

    public NumberListener(TextView view){
        this.view = view;
    }


    @Override
    public void onClick(View view) {

        Pattern dec = Pattern.compile("^([-]*[0-9]*)");

        Pattern decf = Pattern.compile("^(([-]*[0-9]+[.]?)[0-9]*)\\s(.)\\s(([-]*[0-9]*[.]?)[0-9]*)$"); //Applying Not notations, works since the text is a



        String current = this.view.getText().toString();

        Matcher m = dec.matcher(current);
        Matcher  m2 = decf.matcher(current);

        if (m.matches() && m.group(1).toString().length() <= 15){
            current = current + ((Button)view).getText().toString();
            this.view.setText(current);

        }else if (m2.matches() && m2.group(4).toString().length() <= 15){
            current = current + ((Button)view).getText().toString();
            this.view.setText(current);
        }





    }
}
