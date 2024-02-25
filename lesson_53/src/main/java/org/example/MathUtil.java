package org.example;

public class MathUtil {
    public static Integer calculate(String s) {
        String operators[] = s.split("[0-9]+");
        String number[] = s.split("[+-/*]");

        int result = Integer.parseInt(number[0]);
        for (int i = 1; i < number.length; i++) {
            if (operators[i].equals("+")) {
                result += Integer.parseInt(number[i]);
            } else if (operators[i].equals("-")) {
                result -= Integer.parseInt(number[i]);
            } else if (operators[i].equals("/")) {
                result /= Integer.parseInt(number[i]);
            } else if (operators[i].equals("*")) {
                result *= Integer.parseInt(number[i]);
            }
        }
        return result;
    }
}
