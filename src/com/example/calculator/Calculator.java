package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    double num1 = 0, num2 = 0, result = 0;
    char operator = 0;

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
    public double getValidOperator(double num1, double num2, char operator) {
        double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    return 0;
            }
            return result;
    }
}
