import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static char[][] map;
    public static boolean[][][][] visited;
    public static Queue<int[]> coin = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int cc = 0;
        int coin1x = 0;
        int coin1y = 0;

        for(int i=0; i<N; i++){
            String st = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = st.charAt(j);
                if(map[i][j] == 'o' && cc == 0){
                    coin1x = i;
                    coin1y = j;
                    cc++;
                } else if(map[i][j] == 'o' && cc == 1){
                    coin.add(new int[] {coin1x, coin1y, i, j, 0});
                    visited[coin1x][coin1y][i][j] = true;   
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS(){
        while(!coin.isEmpty()){
            int now[] = coin.poll();
            int x1 = now[0];
            int y1 = now[1];
            int x2 = now[2];
            int y2 = now[3];
            
            int time = now[4];
            
            if(time >=10){
                return -1;
                
            }

            for(int i=0; i<4; i++){
            
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                //범위 하나라도 벗어나면
                if((nx1<0 || nx1>=N || ny1<0 || ny1>=M) && ( nx2>=0 && nx2<N && ny2>=0 && ny2<M)){
                    return time+1;
                }
                if((nx2<0 || nx2>=N || ny2<0 || ny2>=M) && (nx1>=0 && nx1<N && ny1>=0 && ny1<M) ){
                    return time+1;
                }

                // 두 동전이 모두 떨어지면 안 됨
                if ((nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) && (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M)) {
                    continue;
                }


                if(nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M && map[nx1][ny1] == '#'){
                    nx1 = x1;
                    ny1 = y1;
                }

                if(nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M && map[nx2][ny2] == '#'){
                    nx2 = x2;
                    ny2 = y2;
                }

                //이동
                //둘다 이동 가능
                if(nx1>=0 && nx1<N && ny1>=0 && ny1<M && nx2>=0 && nx2<N && ny2>=0 && ny2<M){
                    if (!visited[nx1][ny1][nx2][ny2]) {
                        visited[nx1][ny1][nx2][ny2] = true;
                        coin.add(new int[] {nx1, ny1, nx2, ny2, time+1});     
                    }
                       
                }

            }
        }
        return -1;
    }

    
}