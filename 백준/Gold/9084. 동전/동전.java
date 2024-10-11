import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int T=1; T<=tc; T++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer str = new StringTokenizer(br.readLine());
            int cost[] = new int[N];
            for(int i=0; i<N; i++){
                cost[i] = Integer.parseInt(str.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            //입력 끝

            int dp[] = new int[M+1];
            dp[0] = 1;
            

            for(int i=0; i<N; i++){
                int money = cost[i];
                for(int j=money; j<=M; j++){
                    dp[j] += dp[j-money];
                }
            }

            System.out.println(dp[M]);




        }
    }
}