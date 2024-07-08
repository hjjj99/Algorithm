import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        int W[] = new int[N+1];
        int V[] = new int[N+1];

        for(int i=1; i<=N; i++){
            str = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(str.nextToken());
            V[i] = Integer.parseInt(str.nextToken());
        }

        int dp[][] = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                dp[i][j]=dp[i-1][j];
                //넣을 수 있으면
                if(j - W[i]>=0) { 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
				}
            }
        }
        System.out.println(dp[N][K]);
    }
}