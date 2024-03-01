import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 비내림차순, 중복 선택 가능. => 중복 조합
        ccomb(0, new int[M], 0);
        System.out.print(sb);
    }

    static void ccomb(int cnt, int[] selected, int startIdx) {
        if (cnt == M) {
            for (int i = 0; i < cnt; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        } // 기저조건
        for (int i = startIdx; i < N; i++) {
            selected[cnt] = i + 1;
            ccomb(cnt + 1, selected, i);
        }
    }
}