import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(str.nextToken());

        //인원수는 많아도 더 저렴한 방법이 있을수도 있으니까
        int[] dp = new int[C+101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int N = Integer.parseInt(str.nextToken());

        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(str.nextToken());
            int reward = Integer.parseInt(str.nextToken());
            for (int j=reward; j<C+101; j++){
                int prev = dp[j-reward];
                if(prev != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], cost+prev);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=C; i<C+101;i++){
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);

        

    }
}