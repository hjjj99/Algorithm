import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] num;
    public static int[] select;
    public static boolean[] isSelect;
    public static int idx, sidx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        num = new int[N];
        select = new int[M];
        isSelect = new boolean[N];

        str = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(num);

        solve(0);
    }

    public static void solve(int idx) {
        if (idx == M) {
            for (int j : select) {
                System.out.print(j + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isSelect[i]) {
                isSelect[i] = true;
                select[idx] = num[i];
                solve(idx + 1);
                isSelect[i] = false;
            }
        }
    }
}