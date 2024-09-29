import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int dx[] = {1, 0};
    public static int dy[] = {0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int map[][] = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] =Integer.parseInt(str.nextToken());
            }
        }
        
        long dp[][] = new long[N][N];
        dp[0][0] = 1;

       for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (i == N - 1 && j == N - 1) break;
                for(int t=0; t<2; t++){
                    int nx = i + map[i][j]*dx[t];
                    int ny = j + map[i][j]*dy[t];
                    if(nx>=0 && ny>=0 && nx<N && ny<N){
                        dp[nx][ny] += dp[i][j];
                    }
                }
                
            }
        }
        
        System.out.println(dp[N-1][N-1]);


    }
}