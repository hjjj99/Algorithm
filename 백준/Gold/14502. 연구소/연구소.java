import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] testMap;
    static List<Pos> virus;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        testMap = new int[n][m];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 상태 입력 받기
                map[i][j] = num;
                if (num == 2) {
                    virus.add(new Pos(i, j));
                }
            }
        }

        makeWall(0, 0);
        System.out.println(max);

    }

    // 1. backtracking: 벽3개 세우기
    static void makeWall(int start, int wallNum) {

        // 벽이 3개가 세워졌으면
        if (wallNum == 3) {
            // map 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    testMap[i][j] = map[i][j];
                }
            }

            // 모든 바이러스에 대해서 bfs(바이러스 퍼트려)
            for (Pos pos : virus) {
                bfs(pos.x, pos.y);
            }

            // 안정영역의 개수 중 max
            max = Math.max(max, getSafeSize());
            return;
        }

        // 숫자를 0 ~ n*m 까지 증가시킬때 (i/m, i%m) 을 좌표로 하면 2차원 배열의 모든 인덱스를 탐색
        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                // 다음 칸으로, 다음 벽 개수로
                makeWall(i + 1, wallNum + 1);
                map[x][y] = 0;
            }
        }
    }

    // 2. bfs: virus 퍼트리기 (깊은 복사한 map에)
    static void bfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) { // 바이러스 퍼질 조건에 해당하면
                if (testMap[nx][ny] == 0) {
                    testMap[nx][ny] = 2;
                    bfs(nx, ny);
                }
            }
        }
    }

    // 3. 안전영역 개수 세기
    static int getSafeSize() {
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (testMap[i][j] == 0) {
                    size++;
                }
            }
        }
        return size;
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}