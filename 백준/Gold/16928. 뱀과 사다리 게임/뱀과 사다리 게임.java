import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int map[];
    public static int[] up, down;
    public static boolean visited[];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        visited = new boolean[101];

        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        up = new int[101];
        down = new int[101];

        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            up[a] = b;
        }

        for(int i=0; i<M; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            down[a] = b;
        }

        System.out.println(BFS(1, 0));
    }

    public static int BFS(int idx, int c){
        Queue<int[]> q = new LinkedList<>();
        visited[idx] = true;
        q.add(new int[] {idx, c});

        while(!q.isEmpty()){
            int next[] = q.poll();
            int a = next[0];
            int count = next[1];
            if(a == 100){
                return count;
            }
            //해당 칸에 사다리 있다
            if(up[a] != 0){
                a = up[a];
            }
            if(down[a] != 0){
                a = down[a];
            }
            // 주사위를 1~6까지 굴려서 이동
            for (int i = 1; i <= 6; i++) {
                int nextPosition = a + i;
                if (nextPosition > 100) continue;  // 100번 칸을 넘으면 이동 불가
                if (!visited[nextPosition]) {  // 방문하지 않은 칸일 때
                    visited[nextPosition] = true;  // 방문 처리
                    q.add(new int[] {nextPosition, count + 1});  // 다음 위치로 이동
                }
            }
            
        }
        return -1;
    }
}