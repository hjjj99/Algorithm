import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n, m;
    public static int map[][];
    public static int result[][];
    public static boolean visited[][];
    public static int dx[] = {0, 0, -1, 1};
    public static int dy[] = {-1, 1, 0, 0};
    public static int startX, startY;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            str = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        BFS(startX, startY);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    result[i][j] = -1;
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void BFS(int x, int y){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[] {x,y});
		visited[x][y]=true;

        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            for(int i=0; i<4; i++){
                int a = temp[0] + dx[i];
                int b = temp[1]+dy[i];
                if(a>=0 && a< n && b>=0 && b<m) {
					if(!visited[a][b] && map[a][b]==1) {
						visited[a][b]=true;
						result[a][b]=result[temp[0]][temp[1]]+1;
						queue.add(new int[] {a,b});
					}
				}

            }
        }

    }
}