import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, K, minCount;
    public static int[] visited; // 방문 시간을 저장할 배열
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        // 수빈
        N = Integer.parseInt(str.nextToken());
        // 동생
        K = Integer.parseInt(str.nextToken());

        visited = new int[100001]; // 초기화
        minCount = 0;

        // BFS 실행
        BFS(N);
        System.out.println(min);
        System.out.println(minCount);
    }

    public static void BFS(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0}); // {현재 위치, 걸린 시간}
        visited[start] = 1; // 수빈이 위치 방문 기록

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int currentPosition = now[0];
            int currentTime = now[1];

            // 동생 위치에 도착했을 때 최소 시간 및 경로 수 처리
            if (currentPosition == K) {
                if (min > currentTime) {
                    min = currentTime;
                    minCount = 1; // 최소 시간이 갱신되면 경로 수 초기화
                } else if (min == currentTime) {
                    minCount++; // 같은 시간에 도달할 수 있는 경로의 수 증가
                }
                continue; // 이후 경로를 더 탐색하지 않음
            }

            // 가능한 이동 처리: -1, +1, *2
            for (int nextPosition : new int[]{currentPosition - 1, currentPosition + 1, currentPosition * 2}) {
                if (nextPosition < 0 || nextPosition > 100000) continue;

                // 처음 방문하거나, 같은 시간에 도달하는 경우
                if (visited[nextPosition] == 0 || visited[nextPosition] == currentTime + 1) {
                    visited[nextPosition] = currentTime + 1;
                    q.add(new int[] {nextPosition, currentTime + 1});
                }
            }
        }
    }
}