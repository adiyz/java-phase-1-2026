package p03fizzbuzz.p03fizzbuzz01;

import java.util.Scanner;

public class FizzBuzz01 {
    public static void main(String[] args) {
        System.out.println("This is FizzBuzz");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(); // newline
            System.out.println("Pick Method 1 (If-Else) or 2 (Ternary): (1/2)");

            if (scanner.hasNext()) {
                String chosenThang = scanner.next();
                System.out.println(); // newline

                String print = "Method " + chosenThang + " is chosen";
                if (chosenThang.equals("1")) {
                    System.out.println(print);
                    methodIfElse();
                    return;
                } else if (chosenThang.equals("2")) {
                    System.out.println(print);
                    methodTernary();
                    return;
                } else {
                    System.out.println("Invalid input.");
                }

            } else {
                System.out.println("Program terminated.");
                return;
            }
        }
    }

    private static void methodIfElse() {
        for (int x = 1; x <= 100; x++) {
            if (x % 3 == 0 && x % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (x % 3 == 0) {
                System.out.println("Fizz");
            } else if (x % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(x);
            }
        }
    }

    private static void methodTernary() {
        for (int x = 1; x <= 100; x++) {
            String printout = (x % 3 == 0 && x % 5 == 0) ? "FizzBuzz"
                    : (x % 3 == 0) ? "Fizz"
                      : (x % 5 == 0) ? "Buzz"
                        : String.valueOf(x);
            System.out.println(printout);
        }
    }
}
