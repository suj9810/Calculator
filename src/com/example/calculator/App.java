package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double num1, num2, result;
        String str;
        char operator = 0;
        boolean check = true;

        while (check) {
        System.out.println("===== 은주의 계산기 =====");
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        num1 = sc.nextDouble();
        sc.nextLine();

        boolean nonOperator = false;
            while (!nonOperator) {
                System.out.print("사칙연산 기호(➕,➖,✖,➗)를 입력하세요 : ");
                str = sc.nextLine();
                if (str.length() == 1) {
                    operator = str.charAt(0);
                } else {
                    System.out.println("제대로된 기호를 입력해주세요.");
                    continue;
                }

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    nonOperator = true;
                } else {
                    System.out.println("제대로된 기호를 입력해주세요.");
                }
            }

        System.out.print("두 번째 숫자를 입력하세요 : ");
        num2 = sc.nextDouble();

        try {
            switch (operator) {
                case '+':
                    result = calculator.plus(num1, num2);
                    break;
                case '-':
                    result = calculator.minus(num1, num2);
                    break;
                case '*':
                    result = calculator.multiplication(num1, num2);
                    break;
                case '/':
                    result = calculator.division(num1, num2);
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    return;
            }
            System.out.println("계산 결과 : " + result);
        } catch (ArithmeticException e) {
            System.out.println("오류: " + e.getMessage());
        }
            sc.nextLine();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            str = sc.nextLine();

            if (str.equals("exit")) {
                check = false;
                System.out.println("계산을 종료합니다.");
            } else {
                System.out.println("계산기 로딩중...");
            }
        }
        sc.close();
    }
}

