import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int [][] map, counting;
    public static boolean[][][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        map = new int[N][M];
        counting = new int[N][M];
        visited = new boolean [N][M][2];

        for(int i=0; i<N; i++){
            String st = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = st.charAt(j)-'0';
            }
        }

        int result = BFS(0, 0);
        System.out.println(result);

    }

    public static int BFS(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a, b, 0, 1});
        visited[a][b][0] = true;
        counting[a][b] ++;

        while(!q.isEmpty()){
            int next[] = q.poll();
            int x = next[0];
            int y = next[1];
            int wallBroken = next[2];
            int dist = next[3];

            // 목적지에 도착한 경우
            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    // 벽이 없고 방문한 적이 없을 때
                    if (map[nx][ny] == 0 && !visited[nx][ny][wallBroken]) {
                        q.add(new int[] { nx, ny, wallBroken, dist + 1 });
                        visited[nx][ny][wallBroken] = true;
                    }
                    // 벽이 있고 벽을 아직 부수지 않았을 때
                    if (map[nx][ny] == 1 && wallBroken == 0 && !visited[nx][ny][1]) {
                        q.add(new int[] { nx, ny, 1, dist + 1 });
                        visited[nx][ny][1] = true;
                    }
                }
            }

        }

        return -1;
    }
}