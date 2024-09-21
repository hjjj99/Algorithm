import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int size;
    public static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[][] map;
    public static boolean [][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            visited = new boolean[size][size];

            StringTokenizer str = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(str.nextToken());
            int starty = Integer.parseInt(str.nextToken());

            str = new StringTokenizer(br.readLine());
            int endx = Integer.parseInt(str.nextToken());
            int endy = Integer.parseInt(str.nextToken());

            BFS(startx, starty, size);

            System.out.println(map[endx][endy]);
        }
    }
    public static void BFS(int sx, int sy, int size){
        Queue<int[]> q = new LinkedList<>();
        visited[sx][sy] = true;
        q.add(new int[] {sx, sy});
        
        while(!q.isEmpty()){
            int now[] = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && nx<size && ny<size){
                    if(!visited[nx][ny]){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                    }
                } 
            }
        }
    }
}