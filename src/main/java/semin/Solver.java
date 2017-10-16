package semin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import semin.collections.ArrayStack;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN   = '(';
    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';

    public static double evaluate(String[] values) {
        final ArrayStack<String> inputStack = new ArrayStack<>();
        for (String input : values) {
            if (!input.equals(String.valueOf(RIGHT_PAREN))) {
                inputStack.push(input);
            }
            else {
                final double second = Double.valueOf(inputStack.pop());
                final char operation = inputStack.pop().charAt(0);
                double first = Double.valueOf(inputStack.pop());
                inputStack.pop();
                switch (operation) {
                case PLUS:
                    first += second;
                    break;
                case MINUS:
                    first -= second;
                    break;
                case TIMES:
                    first *= second;
                    break;
                case DIVISION:
                    first /= second;
                    break;
                }
                inputStack.push(String.valueOf(first));
            }
        }
        return Double.parseDouble(inputStack.pop());
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}