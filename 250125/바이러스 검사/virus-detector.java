import java.io.*;
import java.util.*;

// Cap: capacity
public class Main {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] customers = new int[n];
        for (int i = 0; i < n; i++) {
            customers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int leaderCap = Integer.parseInt(st.nextToken());
        int memberCap = Integer.parseInt(st.nextToken());

        long totalCount = n;

        for (int i = 0; i < n; i++) {
            customers[i] -= leaderCap;
        }

        for (int customer: customers) {
            if (customer <= 0) continue;

            int tempMemberCount = customer / memberCap;
            if (customer % memberCap == 0) {
                totalCount += tempMemberCount;
                continue;
            }

            totalCount += (tempMemberCount + 1);
        }

        bw.write(String.valueOf(totalCount));
        bw.flush();
        bw.close();
    }
}