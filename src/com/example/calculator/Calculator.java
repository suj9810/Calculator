package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private ArrayList<Integer> firstNum = new ArrayList<>();
    private ArrayList<Integer> secondNum = new ArrayList<>();
    private ArrayList<String> operator = new ArrayList<>();
    private ArrayList<Double> result = new ArrayList<>();

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

    public void removeResult() {
        /* 구현 */
    }
}
