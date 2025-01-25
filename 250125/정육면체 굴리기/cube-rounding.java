import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int up = 0;
        int down = 0;
        int front = 0;
        int back = 0;
        int left = 0;
        int right = 0;

        int[][] board = new int[n][m];
        
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        String[] directions = br.readLine().split(" ");

        for (String direction: directions) {
            if (direction.equals("1")) {
                if (x + 1 >= n || x + 1 < 0) continue;
                x++;

                int tempRight = right;
                int tempLeft = left;
                int tempUp = up;
                int tempDown = down;
                int tempFront = front;
                int tempBack = back;

                right = tempUp;
                up = tempLeft;
                left = tempDown;
                down = tempRight;
            } else if (direction.equals("2")) {
                if (x - 1 >= n || x - 1 < 0) continue;

                x--;

                int tempRight = right;
                int tempLeft = left;
                int tempUp = up;
                int tempDown = down;
                int tempFront = front;
                int tempBack = back;

                left = tempUp;
                up = tempRight;
                right = tempDown;
                down = tempLeft;
            } else if (direction.equals("3")) {
                if (y - 1 >= m || y - 1 < 0) continue;

                y--;

                int tempRight = right;
                int tempLeft = left;
                int tempUp = up;
                int tempDown = down;
                int tempFront = front;
                int tempBack = back;

                down = tempBack;
                back = tempUp;
                up = tempFront;
                front = tempDown;
            } else if (direction.equals("4")) {
                if (y + 1 >= m || y + 1 < 0) continue;

                y++;

                int tempRight = right;
                int tempLeft = left;
                int tempUp = up;
                int tempDown = down;
                int tempFront = front;
                int tempBack = back;

                down = tempFront;
                back = tempDown;
                up = tempBack;
                front = tempUp;
            }

            if (board[y][x] == 0) {
                board[y][x] = down;
            } else {
                down = board[y][x];
                board[y][x] = 0;
            }
            System.out.println(up);
        }

    }
    
}
