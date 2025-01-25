import java.io.*;
import java.util.*;

// Cap: capacity
public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer customerSt = new StringTokenizer(br.readLine());

        StringTokenizer teamConfig = new StringTokenizer(br.readLine());
        int leaderCap = Integer.parseInt(teamConfig.nextToken());
        int memberCap = Integer.parseInt(teamConfig.nextToken());

        long totalCount = 0;

        for (int i = 0; i < n; i++) {
            int customer = Integer.parseInt(customerSt.nextToken());

            customer -= leaderCap;
            totalCount++;   

            if (customer > 0) {
                totalCount += (customer + memberCap - 1) / memberCap;
            }
        }
        bw.write(String.valueOf(totalCount));
        bw.flush();
        bw.close();
    }
}