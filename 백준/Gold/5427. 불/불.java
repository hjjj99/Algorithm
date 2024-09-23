import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static char[][] map;
    public static boolean[][] visited;
    public static Queue<int[]> fire = new LinkedList<>();
    public static Queue<int[]> user = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            M = Integer.parseInt(str.nextToken());
            N = Integer.parseInt(str.nextToken());

            map = new char[N][M];
            visited = new boolean[N][M];

            fire.clear();
            user.clear();

            for (int i = 0; i < N; i++) {
                String st = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = st.charAt(j);
                    if (map[i][j] == '@') {
                        user.add(new int[]{i, j, 0});
                        visited[i][j] = true;
                    }
                    if (map[i][j] == '*') {
                        fire.add(new int[]{i, j});
                    }
                }
            }

            int result = BFS();
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    public static int BFS() {
        while (!user.isEmpty()) {
            // 불이 먼저 퍼짐
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] fireNow = fire.poll();
                int fire_x = fireNow[0];
                int fire_y = fireNow[1];
                for (int j = 0; j < 4; j++) {
                    int nfx = fire_x + dx[j];
                    int nfy = fire_y + dy[j];
                    if (nfx >= 0 && nfx < N && nfy >= 0 && nfy < M) {
                        if (map[nfx][nfy] == '.') {
                            map[nfx][nfy] = '*';
                            fire.add(new int[]{nfx, nfy});
                        }
                    }
                }
            }

            // 상근이 이동
            int userSize = user.size();
            for (int i = 0; i < userSize; i++) {
                int[] userNow = user.poll();
                int user_x = userNow[0];
                int user_y = userNow[1];
                int time = userNow[2];

                // 가장자리에 도달하면 탈출 성공
                if (user_x == 0 || user_x == N - 1 || user_y == 0 || user_y == M - 1) {
                    return time + 1;
                }

                for (int j = 0; j < 4; j++) {
                    int nux = user_x + dx[j];
                    int nuy = user_y + dy[j];
                    if (nux >= 0 && nux < N && nuy >= 0 && nuy < M) {
                        if (!visited[nux][nuy] && map[nux][nuy] == '.') {
                            visited[nux][nuy] = true;
                            user.add(new int[]{nux, nuy, time + 1});
                        }
                    }
                }
            }
        }
        return -1; // 탈출 불가능
    }
}