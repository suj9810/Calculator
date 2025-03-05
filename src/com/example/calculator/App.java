package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorRecord calculatorRecord = new CalculatorRecord();
        Calculator calculator = new Calculator();
        double num1 = 0, num2 = 0, result = 0;
        String str;
        char operator = 0;
        boolean check = true;

        while (check) {
            System.out.println("\n===== 은주의 계산기 =====");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 기록 보기");
            System.out.println("3. 계산 기록 수정하기");
            System.out.println("4. 계산 기록 삭제하기");
            System.out.println("5. 종료");
            System.out.println("원하는 작업을 선택하세요 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    num1 = getNumber(sc, "첫 번째 ");
                    operator = getOperator(sc);
                    num2 = getNumber(sc, "두 번째 ");
                    try {
                        result = calculator.getValidOperator(num1, num2, operator);
                        System.out.println("결과 : " + result);
                        calculatorRecord.saveCalculation(num1, num2, operator, result);
                    } catch (ArithmeticException e) {
                        System.out.println("오류 : " + e.getMessage());
                    }
                    break;
                case 2:
                    calculatorRecord.displayCalculations();
                    break;
                case 3:
                    System.out.println("수정할 계산의 인덱스를 입력하세요 : ");
                    int indexModify = sc.nextInt();
                    sc.nextLine();
                    num1 = getNumber(sc, "수정을 원하는 첫 번째 ");
                    operator = getOperator(sc);
                    num2 = getNumber(sc, "수정을 원하는 두 번째 ");
                    try {
                        result = calculator.getValidOperator(num1, num2, operator);
                        calculatorRecord.modifyCalculation(indexModify, num1, num2, operator, result);
                    } catch (ArithmeticException e) {
                        System.out.println("오류 : " + e.getMessage());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("수정 가능한 인덱스 번호가 없습니다.");
                    }
                    break;
                case 4:
                    if (calculatorRecord.removeCalculation()) {
                        System.out.println("첫 번째 계산 기록이 삭제 되었습니다.");
                    } else {
                        System.out.println("삭제할 계산 기록이 없습니다.");
                    }
                    break;
                case 5:
                    check = false;
                    System.out.println("계산기를 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
            if (choice != 5) {
                System.out.println("더 계산하시겠습니까? 계속 진행하시려면 아무키 입력 (exit 입력 시 종료) : ");
                str = sc.nextLine();

                if (str.equals("exit")) {
                    check = false;
                    System.out.println("계산을 종료합니다.");
                } else {
                    System.out.println("계산기 로딩중...");
                }
            }

        }
        sc.close();
    }

    private static double getNumber(Scanner sc, String test) {
        double num;
        while (true) {
            System.out.print(test + "숫자를 입력하세요 (양의 정수만 입력 가능): ");
            if (sc.hasNextDouble()) {
                num = sc.nextDouble();
                if (num >= 0) {
                    sc.nextLine(); // 버퍼 비우기
                    return num; // 양의 정수일 경우 반복 종료
                } else {
                    System.out.println("양의 정수를 입력해주세요.");
                }
            } else {
                System.out.println("숫자를 입력해주세요.");
                sc.next(); // 잘못된 입력 제거
            }
        }
    }

    private static char getOperator(Scanner sc) {
        while (true) {
            System.out.print("사칙연산 기호(➕,➖,✖,➗)를 입력하세요 : ");
            String str = sc.nextLine();
            if (str.length() == 1) {
                char operator = str.charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    return operator;
                }
            }
            System.out.println("제대로된 기호를 입력해주세요.");
        }
    }
}

