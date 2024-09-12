import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXYZ {
    int height;
    int row;
    int col;
    
    public PointXYZ(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static int N, M, H;
    public static int[][][] box;
    public static int[] dx = {-1, 1, 0, 0, 0, 0}; // 행 이동
    public static int[] dy = {0, 0, -1, 1, 0, 0}; // 열 이동
    public static int[] ha = {0, 0, 0, 0, 1, -1}; // 높이 이동
    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str.nextToken()); // 가로 크기
        N = Integer.parseInt(str.nextToken()); // 세로 크기
        H = Integer.parseInt(str.nextToken()); // 높이

        box = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                str = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(str.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new PointXYZ(i, j, k)); // 익은 토마토의 좌표를 큐에 추가
                    }
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        while (!queue.isEmpty()) {
            PointXYZ point = queue.poll();
            int height = point.height;
            int row = point.row;
            int col = point.col;

            for (int i = 0; i < 6; i++) {
                int nh = height + ha[i];
                int nr = row + dx[i];
                int nc = col + dy[i];

                // 범위를 올바르게 체크
                if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (box[nh][nr][nc] == 0) { // 익지 않은 토마토일 경우
                        queue.add(new PointXYZ(nh, nr, nc));
                        box[nh][nr][nc] = box[height][row][col] + 1; // 날짜 증가
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        // 결과 검사
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) { // 익지 않은 토마토가 남아있으면
                        return -1;
                    }
                    result = Math.max(result, box[i][j][k]); // 최대 날짜를 갱신
                }
            }
        }

        // 모든 토마토가 익은 경우, 처음에 모두 익어있었다면 0을 반환
        return result == 1 ? 0 : result - 1;
    }
}