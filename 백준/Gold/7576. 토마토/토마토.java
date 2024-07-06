import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static int N, M;
    public static int[][] box;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        M = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());

        box= new int[N][M];

        for(int i=0; i<N; i++){    
            str = new StringTokenizer(br.readLine());      
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(str.nextToken());
                if (box[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }    
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        while(!q.isEmpty()){
            int[] t= q.poll();
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                //상하좌우에 덜익은 토마토가 있으면
                if (box[nx][ny] == 0) {
                    //전 일차 + 1 더하기
                    box[nx][ny] = box[x][y] + 1;
                    //큐에 넣기
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if (allDone()) {
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (max < box[i][j]) {
                        max = box[i][j];
                    }
                }
            }

            return max - 1;
        }
    }

    public static boolean allDone(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}