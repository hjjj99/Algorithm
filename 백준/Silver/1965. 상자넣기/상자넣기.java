import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = (Integer.parseInt(br.readLine()));
        int num[] = new int[N+1];

        StringTokenizer str = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            num[i] = Integer.parseInt(str.nextToken());
        }

        int DP[] = new int[N+1];

        for(int i=1; i<=N; i++){
            DP[i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<=i; j++){
                if(num[j] < num[i]){
                    DP[i] = Math.max(DP[i], DP[j]+1);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            result = Math.max(DP[i], result);
        }

        System.out.println(result);


    }
}