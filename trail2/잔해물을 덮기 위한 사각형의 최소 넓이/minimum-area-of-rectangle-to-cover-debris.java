import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 파이썬의 setting 함수를 자바 메서드로 구현
    public static int setting(String str) {
        return Integer.parseInt(str) + 1000;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.nanoTime() > 0 ? System.in : System.in));
        
        // 2001 x 2001 크기의 2차원 배열 생성 (자바는 기본적으로 0으로 초기화됨)
        int[][] arr = new int[2001][2001];

        // 첫 번째 사각형 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1_origin = setting(st.nextToken());
        int y1_origin = setting(st.nextToken());
        int x2_origin = setting(st.nextToken());
        int y2_origin = setting(st.nextToken());

        // 첫 번째 사각형 영역을 1로 채움
        for (int i = x1_origin; i < x2_origin; i++) {
            for (int j = y1_origin; j < y2_origin; j++) {
                arr[i][j] = 1;
            }
        }

        // 두 번째 사각형 입력 처리
        st = new StringTokenizer(br.readLine());
        int x1 = setting(st.nextToken());
        int y1 = setting(st.nextToken());
        int x2 = setting(st.nextToken());
        int y2 = setting(st.nextToken());

        // 두 번째 사각형 영역을 0으로 지움
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                arr[i][j] = 0;
            }
        }

        int max_v = 0;
        int row_count = 0;

        // edge case (사각형이 2개로 쪼개지는 경우 [가로/세로]) 조건 체크
        if ((x1 < x1_origin && x2 > x2_origin && y1_origin < y1 && y1 < y2 && y2 < y2_origin) ||
            (x1_origin < x1 && x1 < x2 && x2 < x2_origin && y1 < y1_origin && y2 > y2_origin)) {
            
            System.out.println((x2_origin - x1_origin) * (y2_origin - y1_origin));
            
        } else {
            // 남은 잔해물 카운트 연산
            for (int i = x1_origin; i < x2_origin; i++) {
                int count = 0;
                for (int j = y1_origin; j < y2_origin; j++) {
                    if (arr[i][j] == 1) {
                        count++;
                    }
                }
                // 현재 행에 잔해물이 남아있다면 행 개수를 하나 올림
                if (count > 0) {
                    row_count++;
                }
                // 한 행이 가지는 1의 개수(잔해물) 최대값 업데이트
                if (max_v < count) {
                    max_v = count;
                }
            }

            System.out.println(max_v * row_count);
        }
    }
}