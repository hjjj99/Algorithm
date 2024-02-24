import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int sel[];
    public static int num[];
    public static int N;
    public static int idx, sidx;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            num = new int[N];
            sel = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            // 입력 끝
            combination(0, 0);
            System.out.println();
        }
    }

    public static void combination(int idx, int sidx) {
        if (sidx == 6) {
            for (int i = 0; i < 5; i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.print(sel[5]);
            System.out.println();
            return;
        }
        if (idx == N) {
            return;
        }
        sel[sidx] = num[idx];
        combination(idx + 1, sidx + 1);
        combination(idx + 1, sidx);
    }
}