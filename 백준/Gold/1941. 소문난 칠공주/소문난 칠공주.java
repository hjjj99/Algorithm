import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static char[][] map = new char[5][5];
    public static int ans = 0;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    static int combX[] = new int[25];
    static int combY[] = new int[25];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //좌표 미리 계산
        for(int i=0; i<25; i++){
            combX[i] = i%5;
            combY[i] = i/5;
        }

        //백트래킹으로 7개 고르기
        combination(new int[7],0, 0, 7);

        System.out.println(ans);
    }

    public static void combination(int[] comb, int idx, int depth, int left){
        //left : 더 선택해야 할 개수
        if(left == 0){
            //7개 선택했다
            BFS(comb);
            return;
        }
        if( depth == 25) return;

        comb[idx] = depth;
        combination (comb, idx+1, depth+1, left-1);
        combination (comb, idx, depth+1, left);
    }

    public static void BFS(int[] comb){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[7];

        visited[0] = true;
        q.add(comb[0]);
        int cnt = 1; int sCnt = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            if(map[combY[now]][combX[now]] == 'S') sCnt ++;
            for(int i=0; i<4; i++){
                for(int next=1; next<7; next++){
                    if(!visited[next] && combX[now] + dx[i] == combX[comb[next]] && combY[now] + dy[i] == combY[comb[next]]){
                        visited[next] = true;
                        q.add(comb[next]);
                        cnt++;
                    }
                }
            }
        }

        if(cnt == 7){
            if(sCnt >= 4){
                ans++;
            }
        }
    }
}