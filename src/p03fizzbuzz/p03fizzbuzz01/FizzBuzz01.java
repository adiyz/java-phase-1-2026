package p03fizzbuzz.p03fizzbuzz01;

import java.util.Scanner;

public class FizzBuzz01 {
    public static void main(String[] args) {
        System.out.println("This is FizzBuzz");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Pick Method 1 or 2: (1/2)");
            if (scanner.hasNext()) {
                String chosenThang = scanner.next();
                String print = "Method " + chosenThang + " is chosen";
                if (chosenThang.equals("1")) {
                    System.out.println(print);
                    method1();
                    return;
                } else if (chosenThang.equals("2")) {
                    System.out.println(print);
                    method2();
                    return;
                } else {
                    System.out.println("Invalid input.");
                }
            } else {
                System.out.println("Program terminated.");
                System.exit(0);
            }
        }
    }

    private static void method1() {
        for (int x = 0; x <= 100; x++) {
            if (x % 5 == 0 && x % 3 == 0) {
                System.out.println(x + " FizzBuzz");
            } else if (x % 3 == 0) {
                System.out.println(x + " Fizz");
            } else if (x % 5 == 0) {
                System.out.println(x + " Buzz");
            } else {
                System.out.println(x);
            }
        }
    }

    private static void method2() {
        for (int x = 0; x <= 100; x++) {
            String printout = (x % 3 == 0 && x % 5 == 0) ? "FizzBuzz"
                    : (x % 3 == 0) ? "Fizz"
                      : (x % 5 == 0) ? "Buzz" : "";
            System.out.println(x + " " + printout);
        }
    }
}
