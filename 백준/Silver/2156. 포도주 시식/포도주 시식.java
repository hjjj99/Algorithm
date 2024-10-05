import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];

        // 포도주 양 입력 받기
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        // 기저 조건 처리
        if (N == 1) {
            System.out.println(num[1]);
            return;
        }

        dp[1] = num[1];
        if (N > 1) {
            dp[2] = num[1] + num[2];
        }

        // 동적 계획법 적용
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + num[i], dp[i - 3] + num[i - 1] + num[i]));
        }

        // 최댓값 출력
        System.out.println(dp[N]);
    }
}