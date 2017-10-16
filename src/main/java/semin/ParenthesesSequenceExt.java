package semin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import semin.collections.ArrayStack;

/**
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 *      взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 *      к которой приписана слева или справа правильная скобочная последовательность
 *      — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    public static boolean isBalanced(String sequence) {
        //
        ArrayStack<Character> charStack = new ArrayStack<>();
        for (int i = 0; i < sequence.length(); i++) {
            char curChar = sequence.charAt(i);
            char right = 0;
            switch (curChar) {
            case LEFT_PAREN:
            case LEFT_BRACE:
            case LEFT_BRACKET:
                charStack.push(curChar);
                break;
            case RIGHT_PAREN:
                right = LEFT_PAREN;
                break;
            case RIGHT_BRACE:
                right = LEFT_BRACE;
                break;
            case RIGHT_BRACKET:
                right = LEFT_BRACKET;
                break;
            default:
                throw new IllegalArgumentException("incorrect input ");
            }
            if (right != 0) {
                if (charStack.isEmpty() || right != charStack.pop()) {
                    return false;
                }
            }
        }

        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

