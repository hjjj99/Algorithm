import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int H, W, X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] B = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] A = new int[H][W];

        // for문 범위 변경 -> (H + X, W + Y)로 할 필요 없음
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // A, B 배열 모두에 포함되는 경우
                if (i >= X && j >= Y) {
                    A[i][j] = B[i][j] - A[i - X][j - Y];
                } else if (i < X || j < Y) { // 둘 다 포함되지 않거나, 배열 중 하나에 포함되는 경우
                    A[i][j] = B[i][j];
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}