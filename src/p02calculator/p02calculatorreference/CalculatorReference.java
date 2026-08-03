package p02calculator.p02calculatorreference;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculatorReference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            boolean running = true;
            while (running) {
                double a  = readNumber(in, "First number: ");
                String op = readOperator(in);
                double b  = readNumber(in, "Second number: ");
                printResult(a, op, b);
                running = readYesNo(in, "Another calculation? [y/n]: ");
            }
            System.out.println("Goodbye.");
        } catch (NoSuchElementException e) {
            System.out.println("\nInput ended. Goodbye.");
        }
    }

    // Single choke point for reading. Throws at EOF — main catches it, once.
    private static String readLine(Scanner in, String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }

    private static double readNumber(Scanner in, String prompt) {
        while (true) {
            String line = readLine(in, prompt);
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("  '" + line + "' is not a number.");
            }
        }
    }

    private static String readOperator(Scanner in) {
        while (true) {
            String line = readLine(in, "Operator (+ - * / ^): ");
            if (line.equals("+") || line.equals("-") || line.equals("*")
                    || line.equals("/") || line.equals("^")) {
                return line;
            }
            System.out.println("  '" + line + "' is not an operator I know.");
        }
    }

    private static boolean readYesNo(Scanner in, String prompt) {
        while (true) {
            String line = readLine(in, prompt).toLowerCase();
            if (line.equals("y") || line.equals("yes")) return true;
            if (line.equals("n") || line.equals("no"))  return false;
            System.out.println("  Please answer y or n.");
        }
    }

    private static void printResult(double a, String op, double b) {
        if (op.equals("/") && b == 0) {
            System.out.println("Cannot divide by zero.");
            return;
        }
        double result = switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            case "^" -> Math.pow(a, b);
            default  -> throw new IllegalStateException("Unreachable: " + op);
        };
        if (Double.isFinite(result)) {
            System.out.printf("= %.2f%n", result);
        } else {
            System.out.println("= " + result + " (not a usable number)");
        }
    }
}