package chapter_9_Recursion_DP;

public class Question_9_8 {

    private static int[] denominations = {25, 10, 5, 1};

    public static void main(String[] args) {
        System.out.println("n\tways");
        for (int n = 0; n <= 100; n++) {
            System.out.println(n + "\t" + representCents(n));
        }
    }

    public static int representCents(int n) {
        return representCents(n, 0);
    }

    public static int representCents(int n, int idx) {
        // on last denomination, only one way to represent
        if (idx >= denominations.length - 1) {
            return 1;
        }

        int representations = 0;
        for (int i = 0; i * denominations[idx] <= n; i++) {
            // use next denomination
            representations += representCents(n - (i * denominations[idx]), (idx + 1));
        }

        return representations;
    }

}
