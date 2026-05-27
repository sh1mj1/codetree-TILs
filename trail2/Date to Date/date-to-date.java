import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int temp = 0;
        for (int i = m1; i <m2; i++) {
            temp += m[i-1];
        }

        System.out.println(temp + d2 - d1 + 1);
    } 
}