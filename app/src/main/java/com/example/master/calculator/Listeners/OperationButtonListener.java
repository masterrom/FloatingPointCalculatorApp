package com.example.master.calculator.Listeners;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Path;
import android.service.carrier.CarrierMessagingService;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.master.calculator.Factory.OperationStrategyFactory;
import com.example.master.calculator.OperationStrategiesFiles.OperationStrategy;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Master on 25-Dec-17.
 */

public class OperationButtonListener implements View.OnClickListener {

    private TextView view;
    private OperationStrategyFactory factoryy;
    private ArrayList<String> listitems;
    private ArrayAdapter<String> listAdapter;
    public OperationButtonListener(TextView view, ArrayList<String> listitems, ArrayAdapter<String> ad){
        this.view = view;
        this.listitems = listitems;
        this.factoryy = new OperationStrategyFactory();
        this.listAdapter = ad;
    }

    @Override
    public void onClick(View view) {

        String current  = this.view.getText().toString();


        Pattern dec = Pattern.compile("^([-]*[0-9]+[.]?)[0-9]*$");
        Pattern newSymbol = Pattern.compile("^(([-]*[0-9]+[.]?)[0-9]*)\\s(.)\\s$");

        Pattern decf = Pattern.compile("^(([-]*[0-9]+[.]?)[0-9]*)\\s(.)\\s(([-]*[0-9]+[.]?)[0-9]*)$"); //Applying Not notations, works since the text is a


        Matcher md = dec.matcher(current);
        Matcher mdd = decf.matcher(current);
        Matcher mdn = newSymbol.matcher(current);

        //we can use cases
        if ( md.matches()) {
            current = current + " " + ((Button) view).getText().toString() + " ";
            this.view.setText(current);

        }else if (mdn.matches()){

            current = mdn.group(1) + " " + ((Button) view).getText().toString() + " ";
            this.view.setText(current);

        }else if ( mdd.matches()) {
            String symbol = mdd.group(3);
            OperationStrategy operation = this.factoryy.createOperation(symbol);


            String ans  = operation.execute(mdd.group(1), mdd.group(4 ));
            String fin = current + " = " + ans;

            this.listitems.add(fin);
            this.listAdapter.notifyDataSetChanged();

            current = ans +  " " + ((Button)view).getText().toString() +  " ";
            this.view.setText(current);


        }







    }


}
