package com.example.master.calculator.Listeners;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.master.calculator.Factory.OperationStrategyFactory;
import com.example.master.calculator.OperationStrategiesFiles.OperationStrategy;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Master on 04-Jan-18.
 */

public class equalListener implements View.OnClickListener {



    private TextView view;
    private OperationStrategyFactory factoryy;
    private ArrayList<String> listitems;
    private ArrayAdapter<String> listAdapter;
    public equalListener(TextView view, ArrayList<String> listitems, ArrayAdapter<String> ad){
        this.view = view;
        this.listitems = listitems;
        this.factoryy = new OperationStrategyFactory();
        this.listAdapter = ad;
    }

    @Override
    public void onClick(View view) {

        String current  = this.view.getText().toString();


        Pattern dec = Pattern.compile("^([-+]*[0-9]+[.]?)[0-9]*$");
        Pattern newSymbol = Pattern.compile("^(([-+]*[0-9]+[.]?)[0-9]*)\\s(.)\\s$");

        Pattern decf = Pattern.compile("^(([-+]*[0-9]+[.]?)[0-9]*)\\s(.)\\s(([-+]*[0-9]+[.]?)[0-9]*)$"); //Applying Not notations, works since the text is a


        Matcher md = dec.matcher(current);
        Matcher mdd = decf.matcher(current);
        Matcher mdn = newSymbol.matcher(current);

        //we can use cases
        if ( md.matches()) {
            this.view.setText(current);

        }else if (mdn.matches()){

            current = mdn.group(1);
            this.view.setText(current);

        }else if ( mdd.matches()) {
            String symbol = mdd.group(3);
            OperationStrategy operation = this.factoryy.createOperation(symbol);


            String ans  = operation.execute(mdd.group(1), mdd.group(4 ));
            String fin = current + " = " + ans;

            this.listitems.add(fin);
            this.listAdapter.notifyDataSetChanged();

            current = ans;
            this.view.setText(current);


        }







    }
}
