package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);
    CalculatorRecord CalculatorRecord = new CalculatorRecord();
    double num1 = 0, num2 = 0, result = 0;
    char operator = 0;
    boolean check = true;

    public Calculator(double num1, double num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public Calculator() {

    }

    public double plus(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }
    public double minus(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }
    public double multiplication(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }
    public double division(double firstNum, double secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return firstNum / secondNum;
    }
}
