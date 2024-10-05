import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, count, canEat, sx, sy, eatenFish;
    public static int map[][];
    public static boolean visited[][];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
                if(map[i][j] == 9){
                    sx = i;
                    sy = j;
                    map[i][j] = 0;  // 상어가 있던 자리는 빈 공간으로 변경
                }
            }
        }

        count = 0;
        eatenFish = 0;

        shark(sx, sy, 2, 0);
        System.out.println(count);  // 총 이동 시간을 출력
    }

    public static void shark(int x, int y, int size, int totalTime) {
        while (true) {
            int[] nextFish = findNearestFish(x, y, size);
            if (nextFish == null) {  // 더 이상 먹을 수 있는 물고기가 없으면 종료
                break;
            }

            // 물고기 먹기
            int nx = nextFish[0];
            int ny = nextFish[1];
            int distance = nextFish[2];

            map[nx][ny] = 0;  // 물고기 먹은 자리 빈 칸으로 설정
            eatenFish++;
            totalTime += distance;  // 이동한 거리 추가

            if (eatenFish == size) {  // 상어 크기와 같은 물고기를 먹으면 상어 크기 증가
                size++;
                eatenFish = 0;
            }

            // 상어 위치 업데이트
            x = nx;
            y = ny;
        }

        count = totalTime;  // 최종 이동 시간을 저장
    }

    public static int[] findNearestFish(int x, int y, int size) {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});  // 상어 위치와 이동 거리(초기 0)
        visited[x][y] = true;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            // 먹을 수 있는 물고기 발견 시
            if (map[cx][cy] > 0 && map[cx][cy] < size) {
                if (dist < minDist) {
                    minDist = dist;
                    minX = cx;
                    minY = cy;
                } else if (dist == minDist) {
                    if (cx < minX || (cx == minX && cy < minY)) {
                        minX = cx;
                        minY = cy;
                    }
                }
            }

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) {
            return null;  // 먹을 수 있는 물고기가 없음
        } else {
            return new int[]{minX, minY, minDist};
        }
    }
}