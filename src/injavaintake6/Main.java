package injavaintake6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        week2Task1();
//        week2Task2();
//        week2Task3();
        week2Task4();
    }

    public static void week2Task1() {
        /**
         * Solution:
         * 1. Store input score input variable name "score"
         * 2. Apply condition on the variable score to display grade
         * 3. if score >= 95 and score <= 100 then output Grade A
         * 4. if score >= 90 and score < 95 then output Grade B
         * 5. if score >= 80 and score < 90 then output Grade C
         * 6. if score >= 65 and score < 80 then output Grade D
         * 7. if score >= 50 and score < 65 then output Grade E
         * 8. if score < 50 then output Grade F
         * 9. otherwise  output invalid score
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter score: ");
        int score = scanner.nextInt();

        if (score >= 95 && score <= 100) {
            System.out.println("Grade A");
        } else if (score >= 90 && score < 95) {
            System.out.println("Grade B");
        } else if (score >= 80 && score < 90) {
            System.out.println("Grade C");
        } else if (score >= 65 && score < 80) {
            System.out.println("Grade D");
        } else if (score >= 50 && score < 65) {
            System.out.println("Grade E");
        } else if (score < 50) {
            System.out.println("Grade F");
        } else {
            System.out.println("Invalid score");
        }
    }

    public static void week2Task2() {
        /**
         * Solution:
         * 1. Get user input of rectangle width and store in variable named "width"
         * 2. Get user input of rectangle height and store in variable named "height"
         * 3. Calculate area and perimeter of rectangle
         * 3.1. Area = width * height
         * 3.2. Perimeter = 2 * (width + height)
         * 4. Output Area and Perimeter
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter width: ");
        double width = scanner.nextDouble();

        System.out.print("\nEnter height: ");
        double height = scanner.nextDouble();

        double area = width * height;
        double perimeter = 2 * (width + height);
        // Area = 10 , Perimeter = 15
        System.out.println("Area = " + area + " , Perimeter = " + perimeter);
    }

    public static void week2Task3() {
        /**
         * Solution:
         * 1. Store two input values in variable named "value1" and "value2"
         * 2. Apply conditions:
         * 2.1. if value1 = 30 then output true
         * 2.2. if value2 equals 30 then output true
         * 2.3. if value1 + value 2 = 30 then output true
         * 2.4. otherwise output false
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input value1: ");
        int value1 = scanner.nextInt();

        System.out.print("Input value2: ");
        int value2 = scanner.nextInt();
//        if (value1 == 30) {
//            System.out.println("True");
//        } else if (value2 == 30) {
//            System.out.println("True");
//        } else if (value1 + value2 == 30) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }

//        if (value1 == 30 || value2 == 30 || value1 + value2 == 30) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }
        System.out.println(
                (value1 == 30 || value2 == 30 || value1 + value2 == 30) ? "True" : "False"
        );
    }

    public static void week2Task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input 1: ");
        int input1 = scanner.nextInt();

        System.out.print("Input 2: ");
        int input2 = scanner.nextInt();

        System.out.print("Sign(+, -, *, /, %): ");
        char sign = scanner.next().charAt(0);
        int result = 0;
        switch (sign) {
            case '+':
                result = input1 + input2;
                break;
            case '-':
                result = input1 - input2;
                break;
            case '*':
                result = input1 * input2;
                break;
            case '/':
                result = input1 / input2;
                break;
            case '%':
                result = input1 % input2;
                break;
        }
        System.out.println("Result = " + result);
    }
}
