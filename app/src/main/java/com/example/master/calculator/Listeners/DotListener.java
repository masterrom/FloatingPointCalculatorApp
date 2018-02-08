package com.example.master.calculator.Listeners;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Master on 04-Jan-18.
 */

public class DotListener implements View.OnClickListener {

    private TextView dis;
    public DotListener (TextView dis){
        this.dis = dis;
    }



    @Override
    public void onClick(View view) {


        Pattern p = Pattern.compile("^[-]*\\d+$");
        Pattern op = Pattern.compile("^([-]*\\d+)\\s(.)\\s([-]*\\d+)$"); //Applying Not notations, works since the text is a


        Pattern decf = Pattern.compile("^(([-]*[0-9]+[.]?)[0-9]*)\\s(.)\\s([-]*[0-9]+)$"); //Applying Not notations, works since the text is a




        String current = this.dis.getText().toString();
        Matcher m = p.matcher(current);

        if (m.matches()){
            current = current + ".";
            this.dis.setText(current);
        }

        m = decf.matcher(current);
        if (m.matches()){

            current = current + ".";
            this.dis.setText(current);
        }





    }
}
