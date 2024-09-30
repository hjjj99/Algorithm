import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, S, M;
    public static int[] V;
    public static boolean[][] dp; // DP 배열 선언
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken()); // 곡의 개수
        S = Integer.parseInt(str.nextToken()); // 시작 볼륨
        M = Integer.parseInt(str.nextToken()); // 최대 볼륨

        V = new int[N];
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(str.nextToken());
        }

        // DP 배열 초기화
        dp = new boolean[N + 1][M + 1];
        dp[0][S] = true; // 첫 번째 곡을 시작할 때의 볼륨 설정

        // DP 진행
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) { // 이전 곡에서 j 볼륨이 가능했을 때
                    if (j + V[i - 1] <= M) { // 볼륨을 더한 값이 M 이하일 때
                        dp[i][j + V[i - 1]] = true;
                    }
                    if (j - V[i - 1] >= 0) { // 볼륨을 뺀 값이 0 이상일 때
                        dp[i][j - V[i - 1]] = true;
                    }
                }
            }
        }

        // 마지막 곡에서 가능한 최대 볼륨을 찾기
        int result = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                result = i;
                break;
            }
        }

        System.out.println(result); // 가능한 최대 볼륨 출력
    }
}