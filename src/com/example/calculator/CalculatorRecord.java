package com.example.calculator;

import java.util.ArrayList;

public class CalculatorRecord {
    private ArrayList<Double> firstNumbers = new ArrayList<>();
    private ArrayList<Double> secondNumbers = new ArrayList<>();
    private ArrayList<Character> operators = new ArrayList<>();
    private ArrayList<Double> results = new ArrayList<>();

    //getter
    public Double getResults(int index) {
        if (index >= 0 && index < results.size()){
            return results.get(index);
        }
        return null;
    }
    //setter
    public void setResults(int index, double result) {
        if (index >= 0 && index < results.size()){
            results.set(index, result);
        }
    }

   //계산 저장
    public void saveCalculation(double firstNum, double secondNum,
                                char operator, double result) {
        this.firstNumbers.add(firstNum);
        this.secondNumbers.add(secondNum);
        this.operators.add(operator);
        this.results.add(result);
    }
    //계산 수정
    public void modifyCalculation(int index, double firstNum, double secondNum,
                                  char operator, double result) {
        if (index >= 0 && index < this.results.size()){
            this.firstNumbers.set(index, firstNum);
            this.secondNumbers.set(index, secondNum);
            this.operators.set(index, operator);
            this.results.set(index, result);
        }
    }

    //계산 삭제
    public boolean removeCalculation() {
        if (!results.isEmpty()) {
            this.firstNumbers.remove(0);
            this.secondNumbers.remove(0);
            this.operators.remove(0);
            this.results.remove(0);
            return true;
        }
        return false;
    }

    //계산 기록 표시
    public void displayCalculations () {
        if (results.isEmpty()){
            System.out.println("계산 기록이 없습니다.");
            return;
        }
        System.out.println("계산 기록 : ");
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("%d: %.2f %c %.2f = %.2f%n", i,
                    firstNumbers.get(i), operators.get(i), secondNumbers.get(i), results.get(i));

        }
    }

    //계산 횟수
    public int getCalculationCount() {
        return results.size();
    }
}
