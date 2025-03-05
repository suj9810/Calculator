## Calculator-Project

계산기 프로젝트

🖥️ 프로젝트 소개
---
사칙연산을 계산해주는 프로젝트입니다.

## 🕰️ 개발 기간

- 25.02.25화 - 25.03.06목

## 📌 주요 기능

- 양의 정수(0 포함)를 입력받기
- 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
- 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
- “exit” 문자열을 입력하기 전까지 무한으로 계산하기

## 📃 실행 화면

**✅ Lv1**

<img width="220" alt="1112025-03-06" src="https://github.com/user-attachments/assets/10a34e98-a3b8-4325-81a5-f38bda001256" />



**✅ Lv2**

|계산하기|기록보기|수정하기|삭제하기|
|---|---|---|---|
|<img width="272" alt="lv2 기능1" src="https://github.com/user-attachments/assets/28076c6f-377b-47ec-b670-edc0eec9dee8" />|<img width="271" alt="lv2 기능2" src="https://github.com/user-attachments/assets/0c6ed543-81d1-4342-9cc4-73c289c86096" />|<img width="278" alt="lv2 기능3" src="https://github.com/user-attachments/assets/66d87426-9964-4689-8d8e-dfd09cf9ff0b" />|<img width="279" alt="lv2 기능4" src="https://github.com/user-attachments/assets/beb04199-9dc9-4035-a45d-51a1934922ff" />

<hr/>

## 📃 코드 리뷰 

**✅ Lv1**

```java
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

```

**✅ Lv2**

```java
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

```


```java
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

```


```java
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

```
