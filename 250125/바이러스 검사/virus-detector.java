import java.util.*;

// Cap: capacity
public class Main {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // restraurant count
        int[] customers = new int[n];
        for (int i = 0; i < n; i++) {
            customers[i] = sc.nextInt();
        }

        int leaderCap = sc.nextInt();
        int memberCap = sc.nextInt();
        
        long total = n;
        for (int i = 0; i < n; i++) {
            customers[i] -= leaderCap;
        }

        for (int customer : customers) {
            if (customer <= 0) continue; 
            int current = customer / memberCap + 1;
            total += current;
        }
        System.out.println(total);
    }
}