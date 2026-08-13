package p02calculator.p02calculator01;

import java.util.Scanner;

public class Calculator01 {

    public static void main(String[] args) {

        boolean programRunningStatus = true;
        String programStatusFlag = "";
        double number1 = 0;
        double number2 = 0;
        String operationMethod = "";
        Scanner scanner = new Scanner(System.in);

        while (programRunningStatus) {

            newline();
            System.out.println("Want to use the calculator program [Y/n]: ");

            if (scanner.hasNext()) {
                programStatusFlag = scanner.next();

                if (programStatusFlag.equalsIgnoreCase("y")) {

                    // getting number1
                    number1 = getDouble(scanner);

                    // getting operation method
                    operationMethod = getOperationMethod(scanner);

                    // getting number2
                    number2 = getDouble(scanner);

                    System.out.printf("""
                        Number 1: %.2f
                        Operation: %s
                        Number 2: %.2f
                        """, number1, operationMethod, number2);

                    // calculating total
                    printTotal(operationMethod, number1, number2);

                } else if (programStatusFlag.equalsIgnoreCase("N")) {
                    programRunningStatus = false;
                    System.out.println("Program exited");
                } else {
                    System.out.println("Unknown command.");
                }
            } else {
                programRunningStatus = false;
                System.out.println("Program terminated.");
            }
        }
    }

    private static String getOperationMethod(Scanner scanner) {
        boolean correctInput = false;
        String operationMethod = "";
        while (!correctInput) {
            System.out.println("Pick an operation method (+, -, *, /).");

            if (scanner.hasNext()) {
                operationMethod = scanner.next();
                if (operationMethod.equals("+") || operationMethod.equals("-")
                        || operationMethod.equals("/") || operationMethod.equals("*")
                        || operationMethod.equals("^")) {
                    correctInput = true;
                } else {
                    System.out.println("Operation method is not included in this program.");
                }
            } else {
                System.out.println("Program terminated.");
                System.exit(0);
            }

        }
        return operationMethod;
    }

    private static void printTotal(String operationMethod, double number1, double number2) {
        double total = 0;
        switch (operationMethod) {
            case "/" -> {
                if (number2 == 0) {
                    System.out.println("Division by zero is not handled by this program.");
                    return;
                } else {
                    total = number1 / number2;
                }
            }
            case "+" -> total = number1 + number2;
            case "-" -> total = number1 - number2;
            case "*" -> total = number1 * number2;
            case "^" -> total = Math.pow(number1, number2);
            default -> System.out.println("Well this is awkward");
        }
        if (Double.isInfinite(total)) {
            System.out.println("The answer is infinite. Congrats.");
        } else if (Double.isNaN(total)) {
            System.out.println("The answer is not a number or NaN.");
        } else {
            System.out.printf("%nThe answer is: %.2f%n", total);
        }

    }

    private static double getDouble(Scanner scanner1) {
        while (true) {
            System.out.println("Input a number: ");
            if (scanner1.hasNext()) {
                if (scanner1.hasNextDouble()) {
                    return scanner1.nextDouble();
                } else {
                    System.out.println("Unknown input.");
                    scanner1.next();
                }
            } else {
                System.out.println("Program terminated.");
                System.exit(0);
            }
        }
    }

    private static void newline() {
        System.out.println();
    }
}

// Known limitations & what I'd do differently

// Input is token-based (scanner.next()), so typing 12 abc 35 at one prompt queues
// the extra tokens as answers to later prompts.
// A line-based read (nextLine() + Double.parseDouble in a try/catch) would
// reject the whole line instead — closer to what a user expects.
// I stayed with tokens because I haven't covered try/catch yet.

// EOF is handled at three separate read sites with System.exit().
// Cleaner: one method all reads pass through, throwing at EOF, with
// a single catch in main. System.exit() also breaks unit tests — it
// kills the test runner, not just the test.

// double for money would be wrong (0.1 isn't exactly representable).
// BigDecimal or integer cents for anything financial.
