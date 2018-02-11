package com.example.master.calculator.Listeners;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.calculator.Main2Activity;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

/**
 * Created by Master on 25-Dec-17.
 */

public class NumberListener implements View.OnClickListener {

    private TextView view;
    private Context context;

    public NumberListener(TextView view, Context c){

        this.view = view;
        this.context = c;
    }


    @Override
    public void onClick(View view) {



        Pattern dec = Pattern.compile("^([-]*[0-9]*)");

        Pattern decf = Pattern.compile("^(([-]*[0-9]+[.]?)[0-9]*)\\s(.)\\s(([-]*[0-9]*[.]?)[0-9]*)$"); //Applying Not notations, works since the text is a
        Pattern afterdot = Pattern.compile("^[-]*\\d+[.](\\d*)$");
        //Possible Patterns
        Pattern p = Pattern.compile("^(-*(\\d)+.{1}\\d*)\\s.{1}\\s(\\d+.{1}\\d*)");
        String current = this.view.getText().toString();


        Matcher m = dec.matcher(current);
        Matcher  m2 = decf.matcher(current);
        Matcher m3 = afterdot.matcher(current);



        if (m.matches() && m.group(1).toString().length() < 15){
            current = current + ((Button)view).getText().toString();
            this.view.setText(current);

        }else if (m2.matches() && m2.group(4).toString().length() < 15){
            current = current + ((Button)view).getText().toString();
            this.view.setText(current);
        }else if (m3.matches()){
            if (m3.group(1).length() < 10){
                current = current + ((Button)view).getText().toString();
                this.view.setText(current);
            }else{
                Toast toast = makeText(this.context,"Maximum 10 digits",LENGTH_SHORT);
                toast.show();
            }
        }else {

            Toast toast = makeText(this.context,"Maximum 15 digits", LENGTH_SHORT);
            toast.show();

        }




    }

}
