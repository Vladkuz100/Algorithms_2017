package semin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import semin.collections.ArrayStack;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) )
 * ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 * <p>
 * 1 + ( 2 + 3 ) * 4 * 5 = 101
 * 1 + 5 * 4 * 5 = 101
 * 1 + 5 * 20 = 101
 * 1 + 100 = 101
 * 20 / 4 = 5
 * (101 - 1) / 5 = 20
 * <p>
 * Считаем, что операции деления на ноль отсутствуют
 */

/**
 * Считаем, что операции деления на ноль отсутствуют
 */
public class SolverExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN   = '(';
    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';

    public static double calcAll(String[] values) {
        final ArrayStack<String> inputStack = new ArrayStack<>();
        inputStack.push(String.valueOf(LEFT_PAREN)); // обернём всё выражение в скобки
        for (String input : values) {
            if (!input.equals(String.valueOf(RIGHT_PAREN))) {
                inputStack.push(input);
            } else {
                final double resultInParen = calcExpr(inputStack);
                inputStack.push(String.valueOf(resultInParen));
            }
        }
        return calcExpr(inputStack);
    }
    
    
    
    private static double calcExpr(ArrayStack<String> inputStack) {
        final ArrayStack<String> inputInParStack = getExprInPar(inputStack);
        final ArrayStack<String> calculatedMult_Div_R  = CalcMult_Div(inputInParStack);
        final ArrayStack<String> calculatedMult_Div_NR = reverseStack(calculatedMult_Div_R );
        return calcPlus_Minus(calculatedMult_Div_NR);
    }

    // переложить содержимое скобок в другой стек в прямом порядке
    private static ArrayStack<String> getExprInPar(ArrayStack<String> inpFirstStack) {
        final ArrayStack<String> inputInParenStack = new ArrayStack<>();
        String input = inpFirstStack.pop();
        while (!input.equals(String.valueOf(LEFT_PAREN))) {
            inputInParenStack.push(input);
            input = inpFirstStack.pop();
        }
        return inputInParenStack;
    }


    private static ArrayStack<String> CalcMult_Div(ArrayStack<String> inputStack) {
        String input;
        final ArrayStack<String> calcedVult_Div = new ArrayStack<>();
        while (!inputStack.isEmpty()) {
            input = inputStack.pop();
            final char operation = input.charAt(0);
            if (operation == TIMES || operation == DIVISION) {
                double first = Double.parseDouble(calcedVult_Div.pop());
                final double second = Double.parseDouble(inputStack.pop());
                switch (operation) {
                case TIMES:
                    first *= second;
                    break;
                case DIVISION:
                    first /= second;
                    break;
                }
                calcedVult_Div.push(String.valueOf(first));
            } else {
                calcedVult_Div.push(input);
            }
        }
        return calcedVult_Div;
    }


    private static ArrayStack<String> reverseStack(ArrayStack<String> tokenStack) {
        final ArrayStack<String> reversedStack = new ArrayStack<>();
        while (!tokenStack.isEmpty()) {
            reversedStack.push(tokenStack.pop());
        }
        return reversedStack;
    }

    private static double calcPlus_Minus(ArrayStack<String> tokenStack) {

        double result = Double.parseDouble(tokenStack.pop());
        while (!tokenStack.isEmpty()) {
            final char operation = tokenStack.pop().charAt(0);
            final double second = Double.parseDouble(tokenStack.pop());
            switch (operation) {
            case PLUS:
                result += second;
                break;
            case MINUS:
                result -= second;
                break;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(calcAll(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


