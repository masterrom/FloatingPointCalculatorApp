package com.example.master.calculator.Factory;

import com.example.master.calculator.OperationStrategiesFiles.OperationStrategy;
import com.example.master.calculator.OperationStrategiesFiles.additionStrategy;
import com.example.master.calculator.OperationStrategiesFiles.divideStrategy;
import com.example.master.calculator.OperationStrategiesFiles.multiplyStrategy;
import com.example.master.calculator.OperationStrategiesFiles.subtractionStrategy;

/**
 * Created by Master on 25-Dec-17.
 */

public class OperationStrategyFactory {

    public OperationStrategy createOperation(String op){
        System.out.println("Op: " + op);

        if (op.equals("+")){
            return new additionStrategy();
        } else if (op.equals("-")){
            return  new subtractionStrategy();
        } else if (op.equals("x") ) {
            return  new multiplyStrategy();
        } else if (op.equals("/")){
            return new divideStrategy();
        } else {
            System.out.println("Has reached null");
            return null;
        }


    }



}
