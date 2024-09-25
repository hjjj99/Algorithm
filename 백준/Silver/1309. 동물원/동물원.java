import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N+1];

        dp[1] = 3;

        if(N > 1) {
            dp[2] = 7;  // N=2일 때 경우의 수는 7가지
        }

        // 점화식으로 dp 계산
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
        }
        
        System.out.println(dp[N]);



    }

    

    
}