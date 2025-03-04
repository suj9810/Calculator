package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0, result;
        String str;
        char operator = 0;
        boolean check = true;
        while (check) {
            System.out.println("은주의 계산기");

            // 첫 번째 숫자 입력 (양의 정수만 허용)
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요 (양의 정수만 입력 가능): ");
                if (sc.hasNextInt()) {
                    num1 = sc.nextInt();
                    if (num1 >= 0) {
                        break; // 양의 정수일 경우 반복 종료
                    } else {
                        System.out.println("양의 정수를 입력해주세요.");
                    }
                } else {
                    System.out.println("숫자를 입력해주세요.");
                    sc.next(); // 잘못된 입력 제거
                }
            }

            sc.nextLine(); // 버퍼 비우기

            // 사칙연산 기호 입력
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

            // 두 번째 숫자 입력 (양의 정수만 허용)
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요 (양의 정수만 입력 가능): ");
                if (sc.hasNextInt()) {
                    num2 = sc.nextInt();
                    if (num2 >= 0) {
                        break; // 양의 정수일 경우 반복 종료
                    } else {
                        System.out.println("양의 정수를 입력해주세요.");
                    }
                } else {
                    System.out.println("숫자를 입력해주세요.");
                    sc.next(); // 잘못된 입력 제거
                }
            }

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println(num1 + " ➕ " + num2 + " 결과 : " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println(num1 + " ➖ " + num2 + " 결과 : " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println(num1 + " ✖ " + num2 + " 결과 : " + result);
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println(num1 + " ➗ " + num2 + " 결과 : " + result);
                    } else {
                        System.out.println("0이외의 값을 넣어주세요.");
                        System.out.println("값을 다시 입력해주세요.");
                    }
                    break;
                default:
                    System.out.println("정확한 기호 입력해주세요.");

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
