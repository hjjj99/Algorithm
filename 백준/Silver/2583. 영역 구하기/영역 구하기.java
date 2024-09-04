import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int M, N, K;
    public static int map[][];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        map = new int[N][M];


        for(int i=0; i<K; i++){
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());
            for(int k=y1; k<y2; k++){
                for(int j=x1; j<x2; j++){
                    map[k][j] = 1;
                }
            }
        }

        ArrayList<Integer> areaCount = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    count = 0;
                    DFS(i, j);
                    areaCount.add(count);
                }
            }
        }

        Collections.sort(areaCount); //오름차순 정렬

        sb.append(areaCount.size()).append('\n'); //Size = 영역의 개수 
		for(int i : areaCount)  {
			sb.append(i + " ");
		}
		
		System.out.println(sb);

    }

    public static void DFS(int x, int y){
        map[x][y] = 1;
        count ++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(map[nx][ny]==0){
                    DFS(nx,ny);
                }
            }
        }
    }
}