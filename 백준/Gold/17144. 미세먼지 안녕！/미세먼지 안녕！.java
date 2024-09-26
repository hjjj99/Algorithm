import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int R, C, T;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map, AC;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        T = Integer.parseInt(str.nextToken());

        map = new int[R][C];
        AC = new int[2][2]; // 공기청정기 위치 저장
        int ACcount = 0;

        for (int i = 0; i < R; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
                if (map[i][j] == -1) { // 공기청정기 위치 기록
                    if (ACcount == 0) {
                        AC[0][0] = i;
                        AC[0][1] = j;
                        ACcount++;
                    } else {
                        AC[1][0] = i;
                        AC[1][1] = j;
                    }
                }
            }
        }

        for (int time = 0; time < T; time++) {
            spreadDust(); // 1. 미세먼지 확산
            operateAirCleaner(); // 2. 공기청정기 작동
        }

        // T초 후 미세먼지의 총량 출력
        System.out.println(calculateTotalDust());
    }

    // 미세먼지 확산
    public static void spreadDust() {
        int[][] tempMap = new int[R][C]; // 확산된 결과를 저장할 임시 맵
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) { // 미세먼지가 있는 칸
                    int spreadAmount = map[i][j] / 5;
                    int spreadCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -1) {
                            tempMap[nx][ny] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    tempMap[i][j] += map[i][j] - spreadAmount * spreadCount; // 남은 미세먼지
                } else if (map[i][j] == -1) {
                    tempMap[i][j] = -1; // 공기청정기 위치 유지
                }
            }
        }
        map = tempMap; // 확산 결과를 원본 맵에 반영
    }

    // 공기청정기 작동
    public static void operateAirCleaner() {
        // 위쪽 공기청정기 (반시계 방향)
        int top = AC[0][0];
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0]; // 아래로 당기기
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1]; // 왼쪽으로 당기기
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1]; // 위로 당기기
        for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1]; // 오른쪽으로 당기기
        map[top][1] = 0; // 공기청정기에서 나오는 공기

        // 아래쪽 공기청정기 (시계 방향)
        int bottom = AC[1][0];
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0]; // 위로 당기기
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1]; // 왼쪽으로 당기기
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1]; // 아래로 당기기
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1]; // 오른쪽으로 당기기
        map[bottom][1] = 0; // 공기청정기에서 나오는 공기
    }

    // T초 후 남아있는 미세먼지의 총량 계산
    public static int calculateTotalDust() {
        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) total += map[i][j];
            }
        }
        return total;
    }
}