package chapter_7_Mathematics_Probability;

import java.util.Random;

//Implement -, *, / for ints using only +
public class Question_7_4 {
    public static final int MAX = 100;

    public static void main(String[] args) {
        Random random = new Random();
        int a = (random.nextInt(MAX + MAX) - MAX);
        int b = (random.nextInt(MAX + MAX) - MAX);

        System.out.println("a\top\tb\tcheck\tresult");
        System.out.println(a + "\t-\t" + b + "\t" + (a - b) + "\t" + subtract(a, b));
        System.out.println(a + "\t*\t" + b + "\t" + (a * b) + "\t" + multiply(a, b));
        System.out.println(a + "\t/\t" + b + "\t" + (a / b) + "\t" + divide(a, b));
    }

    public static int subtract(int a, int b) {
        return a + flip(b);
    }

    public static int flip(int x) {
        int flipped = 0;

        int sign = 0;
        if (x > 0) {
            // x is positive, make -
            sign = -1;
        } else {
            // x s negative, make +
            sign = 1;
        }

        while (x != 0) {
            flipped += sign;
            x += sign;
        }

        return flipped;
    }

    public static int multiply(int a, int b) {
        int result = 0;

        for (int i = absVal(a); i > 0; i--) {
            result += b;
        }

        if (a < 0) {
            result = flip(result);
        }

        return result;
    }

    // find: x = a / b
    // solving yields: a = bx
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divide by 0");
        }

        a = absVal(a);
        b = absVal(b);
        int result = 0;// number of times multiplied (solution)
        int mult = 0;// current multiplication product

        while (mult + b <= a) {
            mult += b;
            result++;
        }

        // negate if necessary
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            result = flip(result);
        }

        return result;
    }

    public static int absVal(int x) {
        if (x < 0) {
            int y = 0;
            while (x != 0) {
                y += 1;
                x += 1;
            }
            return y;
        }
        return x;
    }

}
