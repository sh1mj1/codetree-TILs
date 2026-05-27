import java.util.Scanner;


public class Main {
    private static int[] mDays = {Integer.MAX_VALUE, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // mon == 0 ~~~ sun == 6..

    private static int numDays(int m, int d) {
        int days = 0;
        for (int i = 1; i < m; i++) {
            days += mDays[i];
        }
        return days + d;
    }

    private static int day(String d) {
        switch(d) {
            case "Mon":
                return 0;
            case "Tue":
                return 1;
            case "Wed":
                return 2;
            case "Thu":
                return 3;
            case "Fri":
                return 4;
            case "Sat":
                return 5;
            case "Sun":
                return 6;
            default:
                return -1;
        }
    }



    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        String d = sc.next();
        int dayNum = day(d);

        int numDays1 = numDays(m1, d1);
        int numDays2 = numDays(m2, d2);

        int diff = numDays2 - numDays1;
        diff -= dayNum;

        if (diff < 0) {
            System.out.println(0);
            return;
        }

        System.out.println(diff / 7 + 1);
    }
}