package com.example.calculator;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String mathSymbol;

    OperatorType(String mathSymbol) {
        this.mathSymbol = mathSymbol;
    }

    public String getMathSymbol() {
        return mathSymbol;
    }

    public static OperatorType findValidatedSymbol(String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(v -> v.getMathSymbol().equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("잘못된 연산자입니다.")));
    }
    
    public double operate(double firstNumber, double secondNumber) {
        if (PLUS.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber + secondNumber;
        }
        if (MINUS.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber - secondNumber;
        }
        if (MULTIPLE.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber * secondNumber;
        }
        if (DIVIDE.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber / secondNumber;
        }
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
}
