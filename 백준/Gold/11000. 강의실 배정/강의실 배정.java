import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];

        // N개의 수업 정보 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(str.nextToken()); // 시작 시간
            lectures[i][1] = Integer.parseInt(str.nextToken()); // 끝나는 시간
        }

        // 수업을 시작 시간 기준으로 정렬
        Arrays.sort(lectures, (a, b) -> a[0] - b[0]);

        // 우선순위 큐 (끝나는 시간 기준으로 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 첫 번째 수업의 끝나는 시간을 큐에 추가
        pq.add(lectures[0][1]);

        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 수업이 현재 수업의 시작 시간 이전에 끝났으면 그 강의실을 재사용 가능
            if (pq.peek() <= lectures[i][0]) {
                pq.poll(); // 가장 빨리 끝나는 수업 제거
            }

            // 현재 수업의 끝나는 시간을 큐에 추가
            pq.add(lectures[i][1]);
        }

        // 큐의 크기가 필요한 강의실의 최소 개수
        System.out.println(pq.size());
    }
}