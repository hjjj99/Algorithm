import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int [][]num;
    public static boolean [][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        num = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                num[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int max = 0;
        int count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(num[i][j] == 0 || visited[i][j]){
                    continue;
                }
                count ++;
                visited[i][j] = true;

                //0이 아니면 q에 넣기
                q.offer(new int[] {i, j});

                int area = 0;
                while(!q.isEmpty()){
                    area++;
                    int[] temp = q.poll();
                    int x = temp[0];
                    int y = temp[1];

                    for(int dir = 0;dir < 4; dir++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        //갈수 없는 경우
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(visited[nx][ny] || num[nx][ny] !=1) continue;
                        
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
                max = Math.max(max,area);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

}