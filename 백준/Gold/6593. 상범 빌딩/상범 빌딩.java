import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int h, r, c;

    public Point(int h, int r, int c) {
        this.h = h;
        this.r = r;
        this.c = c;
    }
}

public class Main {
    public static int L, R, C;
    public static char[][][] build;
    public static int[][][] result;
    public static int[] dh = {1, -1, 0, 0, 0, 0}; // 위, 아래
    public static int[] dr = {0, 0, 1, -1, 0, 0}; // 남, 북
    public static int[] dc = {0, 0, 0, 0, 1, -1}; // 동, 서
    public static int eh, er, ec; // 출구 위치
    public static Queue<Point> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            L = Integer.parseInt(str.nextToken());
            R = Integer.parseInt(str.nextToken());
            C = Integer.parseInt(str.nextToken());

            // 입력의 끝은 L, R, C가 모두 0으로 표현됨
            if (L == 0 && R == 0 && C == 0) break;

            build = new char[L][R][C];
            result = new int[L][R][C]; // 방문 시간을 기록하는 배열
            queue = new LinkedList<>();

            Point start = null;

            // 빌딩 정보 입력
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        build[l][r][c] = line.charAt(c);
                        if (build[l][r][c] == 'S') {
                            start = new Point(l, r, c); // 시작 지점 저장
                            queue.offer(start);
                            result[l][r][c] = 1; // 시작 지점 방문 처리
                        }
                        if (build[l][r][c] == 'E') {
                            eh = l;
                            er = r;
                            ec = c; // 출구 위치 저장
                        }
                    }
                }
                br.readLine(); // 각 층 사이의 빈 줄 처리
            }

            // BFS 탐색 시작
            int answer = BFS();
            if (answer == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s).");
            }
        }
    }

    public static int BFS() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int h = point.h;
            int r = point.r;
            int c = point.c;

            // 출구에 도달하면 탈출 시간 반환
            if (h == eh && r == er && c == ec) {
                return result[h][r][c] - 1; // 시작을 1로 했으므로 -1
            }

            // 6방향 탐색
            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위를 넘지 않고, 아직 방문하지 않았으며, 빈 칸 또는 출구일 경우
                if (nh >= 0 && nh < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if ((build[nh][nr][nc] == '.' || build[nh][nr][nc] == 'E') && result[nh][nr][nc] == 0) {
                        queue.offer(new Point(nh, nr, nc));
                        result[nh][nr][nc] = result[h][r][c] + 1; // 시간 증가
                    }
                }
            }
        }

        // 출구에 도달하지 못하면 -1 반환
        return -1;
    }
}