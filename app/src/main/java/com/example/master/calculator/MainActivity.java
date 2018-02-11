package com.example.master.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.master.calculator.Listeners.DotListener;
import com.example.master.calculator.Listeners.NumberListener;
import com.example.master.calculator.Listeners.OperationButtonListener;
import com.example.master.calculator.Listeners.equalListener;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    private Button one,two,three,four,five,six,seven,eight,nine,zero,add,sub,div,equal,multi, dot,
            del,clear;

    private Button clHistory,FloatingPage;
    private TextView display;

    private ListView listView;

    private ArrayList<String> listitems;
    private ArrayAdapter ad;

    /*
    Main code structure:
    Main Activity is like a controller, Connects the view and the model together

     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);




        display = (TextView) findViewById(R.id.display);
        clHistory = (Button) findViewById(R.id.clHistory);
        FloatingPage = (Button) findViewById(R.id.floatingPage);

        NumberListener numListener = new NumberListener(display);
        DotListener dotListener = new DotListener(display);

        one = (Button) findViewById(R.id.num1);
        two = (Button) findViewById(R.id.num2);
        three =(Button) findViewById(R.id.num3);
        four =(Button) findViewById(R.id.num4);
        five =(Button) findViewById(R.id.num5);
        six =(Button) findViewById(R.id.num6);
        seven =(Button) findViewById(R.id.num7);
        eight =(Button) findViewById(R.id.num8);
        nine = (Button) findViewById(R.id.num9);
        zero = (Button) findViewById(R.id.num0);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        div = (Button) findViewById(R.id.div);
        multi = (Button) findViewById(R.id.multi);
        dot = (Button) findViewById(R.id.dot);
        del = (Button) findViewById(R.id.del);
        clear = (Button) findViewById(R.id.clear);



        listView = (ListView) findViewById(R.id.history);
        this.listitems = new ArrayList<String>();
        ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listitems);

        this.listView.setAdapter(ad);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = (String) adapterView.getItemAtPosition(i);
                Pattern p = Pattern.compile("\\d+\\s.+\\s\\d+\\s=\\s(\\d+)");
                Matcher m = p.matcher(selectedItem);
                if (m.matches()){
                    display.setText(m.group(1));
                }

            }
        });

        equal = (Button) findViewById(R.id.equal);
        equalListener eqListener = new equalListener(display, this.listitems,ad);
        equal.setOnClickListener(eqListener);

        one.setOnClickListener(numListener);
        two.setOnClickListener(numListener);
        three.setOnClickListener(numListener);
        four.setOnClickListener(numListener);
        five.setOnClickListener(numListener);
        six.setOnClickListener(numListener);
        seven.setOnClickListener(numListener);
        eight.setOnClickListener(numListener);
        nine.setOnClickListener(numListener);
        zero.setOnClickListener(numListener);
        dot.setOnClickListener(dotListener);

        OperationButtonListener operationListener = new OperationButtonListener(display, this.listitems, ad);
        add.setOnClickListener(operationListener);
        sub.setOnClickListener(operationListener);
        multi.setOnClickListener(operationListener);
        div.setOnClickListener(operationListener);



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
            }
        });





        clHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listitems.clear();
                ad.notifyDataSetChanged();
            }
        });


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (display.getText().toString().length() >= 1){
                    String current = display.getText().toString();
                    display.setText(current.substring(0,current.length()-1));

                }

            }
        });


        FloatingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });












    }
}
