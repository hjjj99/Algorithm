import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int map[][], dist[][];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemCount = 1;

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }

            map = new int[N][N];
            dist = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(str.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            
            System.out.println("Problem " + problemCount++ + ": " + find());
        }

        
    }

    public static int find(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, map[0][0]});
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];

            // 이미 더 좋은 방법으로 도달한 경우 스킵
            if (cost > dist[x][y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newCost = cost + map[nx][ny];

                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}