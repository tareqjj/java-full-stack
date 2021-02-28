package com.CalculatorPartI;

public abstract class Calculator implements java.io.Serializable {
    private static double operandOne = 0.0;
    private static double operandTwo = 0.0;
    private static String operation = "";
    private static double result=0.0;

    public Calculator(){

    }

    public static void setOperandOne(double userOperandOne) {
        operandOne = userOperandOne;
    }

    public static void setOperandTwo(double userOperandTwo) {
        operandTwo = userOperandTwo;
    }

    public static void setOperation(String userOperation) {
        operation = userOperation;
    }

    private static void setResult(double total) {
        result = total;
    }

    public static double getResult() {
        return result;
    }

    public static void performOperation() {
        if (operation == "+")
            setResult(operandOne + operandTwo);
        else
            setResult(operandOne - operandTwo);
    }

    public static void main(String[] args){
        setOperandOne(10.5);
        setOperation("+");
        setOperandTwo(5.2);
        performOperation();
        System.out.println(getResult());

        setOperandOne(50);
        setOperation("-");
        setOperandTwo(30);
        performOperation();
        System.out.println(getResult());
    }
}
