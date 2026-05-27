import java.util.Scanner;

public class Main {
    static int[] mm = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] memo = new int[14];
    static String[] pDiff = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    private static int monthDays(int m) {
        if (m < 1) {
            return 0;
        }
        if (memo[m] != 0) {
            return memo[m];
        }

        memo[m] = monthDays(m - 1) + mm[m - 1];
        return memo[m];
    }
    
    private static int numDays(int m, int d) {
        return (monthDays(m) + d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int numDays1 = numDays(m1, d1);
        int numDays2 = numDays(m2, d2);

        int diff = numDays2 - numDays1;
        int remainder = diff % 7;

        while (remainder < 0) {
            remainder+= 7;
        }

        System.out.println(pDiff[remainder]);
    }
}