import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N+1][10];
        int result[] = new int[N+1];

        // 길이가 1인 오르막 수 초기화
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
            result[1]++;
        }

        // DP 계산
        if (N > 1) {
            for (int i = 2; i <= N; i++) {
                dp[i][0] = result[i-1];
                result[i] += dp[i][0];
                for (int j = 1; j < 10; j++) {
                    dp[i][j] = (dp[i][j-1] - dp[i-1][j-1] + 10007) % 10007;  // 음수 모듈러 처리
                    result[i] += dp[i][j];
                }
            }
        }

        // N자리 오르막 수의 총합 계산
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % 10007);
    }
}