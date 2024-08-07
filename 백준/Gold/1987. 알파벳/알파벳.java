import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visit[map[0][0] - 'A'] = true;
        dfs(1,0,0);
        System.out.println(result);
    }

    static void dfs(int cnt, int x, int y) {
        if(cnt == R*C) {
            result = Math.max(cnt, result);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=C || ny>=R) continue;

            char na = map[ny][nx];

            if(visit[na - 'A']) {
                result = Math.max(cnt, result);
                continue;
            }

            //백트래킹
            visit[na - 'A'] = true;
            dfs(cnt+1, nx, ny);
            visit[na - 'A'] = false;
        }
    }
}