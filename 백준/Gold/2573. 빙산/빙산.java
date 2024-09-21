import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int ans = 0;

        // 반복해서 빙산을 녹이면서 분리 여부를 확인
        while (true) {
            int cnt = SeperateNum();

            // 빙산이 모두 녹았는지 확인
            if (cnt == 0) {
                ans = 0;
                break;
            }

            // 빙산이 2개 이상으로 분리되었을 때
            if (cnt >= 2) {
                break;
            }

            // 빙산 녹이기
            Melt();
            ans++;
        }

        System.out.println(ans);
    }

    // 빙산이 몇 덩어리로 나뉘었는지 확인하는 함수
    public static int SeperateNum() {
        visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // DFS로 빙산 영역 탐색
    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }

    // 빙산이 녹는 함수
    public static void Melt() {
        int[][] tempMap = new int[N][M]; // 녹은 후의 빙산 상태를 저장할 임시 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int seaCount = 0;

                    // 동서남북을 확인하여 바다(0)의 개수 세기
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                            seaCount++;
                        }
                    }

                    // 빙산이 녹는 높이를 계산하여 임시 배열에 저장
                    tempMap[i][j] = Math.max(0, map[i][j] - seaCount);
                }
            }
        }

        // 원래 배열을 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = tempMap[i][j];
            }
        }
    }
}