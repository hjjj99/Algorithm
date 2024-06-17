import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static int map[][];
    public static boolean visited[][];
    public static int dx[] = { -1, 1, 0, 0 };
    public static int dy[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            char[] ch = st.toCharArray();

            for (int j = 0; j < ch.length; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);
            }
        }
        // 입력 끝

        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    public static void BFS(int x, int y) {
        Queue<spot> q = new LinkedList<>();
        q.add(new spot(x, y));

        while (!q.isEmpty()) {
            // 다음 방문
            spot s = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = s.x + dx[i];
                int nextY = s.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }
                q.add(new spot(nextX, nextY));
                map[nextX][nextY] = map[s.x][s.y] + 1;
                visited[nextX][nextY] = true;
            }

        }

    }
}

class spot {
    int x;
    int y;

    spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}