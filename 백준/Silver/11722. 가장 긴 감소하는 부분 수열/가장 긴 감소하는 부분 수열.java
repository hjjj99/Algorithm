import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.DocFlavor.INPUT_STREAM;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] num = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            num[i] = Integer.parseInt(str.nextToken());
            dp[i] = 1;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                //감소하면
                if(num[j] > num[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}