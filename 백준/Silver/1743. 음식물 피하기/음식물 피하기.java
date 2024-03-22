import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K, cnt;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
    public static boolean map[][];
    public static boolean visited[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken())-1;
            int y = Integer.parseInt(str.nextToken())-1;
            map[x][y] = true;
        }

        int ans = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j]){
                    cnt = 0;
                    DFS(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);

    }

    public static void DFS(int i, int j){
        cnt++;
		visited[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || !map[x][y]) 
                continue;
			DFS(x, y);
		}
    }
}