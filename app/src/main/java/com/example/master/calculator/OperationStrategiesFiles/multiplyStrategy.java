package com.example.master.calculator.OperationStrategiesFiles;

/**
 * Created by Master on 25-Dec-17.
 */

public class multiplyStrategy implements OperationStrategy {

    @Override
    public String execute(String x, String y) {

        Float x1 = Float.parseFloat(x);
        Float y1 = Float.parseFloat(y);

        Float total  = x1 * y1;

        if (total == Math.round(total)){

            int n = Math.round(total);
            return n + "";
        }

        return total  + "";


    }

    public void created(){
        System.out.println("Addition strategy is created");
    }
}
