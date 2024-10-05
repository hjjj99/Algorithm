import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> points = new ArrayList<>();
        
        // 선분들의 시작과 끝을 각각 이벤트로 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            
            // 시작점을 +1, 끝나는 점을 -1로 구분
            points.add(new Point(s, 1)); // 선분이 시작되는 시점
            points.add(new Point(e, -1)); // 선분이 끝나는 시점
        }

        // 좌표 기준으로 정렬, 만약 좌표가 같다면 끝나는 이벤트가 먼저 처리되도록 정렬
        Collections.sort(points, (a, b) -> {
            if (a.x == b.x) return a.type - b.type; 
            return a.x - b.x;
        });

        int maxOverlap = 0; // 최대 겹치는 선분 개수
        int currentOverlap = 0; // 현재 겹치는 선분 개수

        // 스위핑하면서 겹치는 선분의 개수 계산
        for (Point p : points) {
            currentOverlap += p.type; // 시작 시 +1, 끝날 시 -1
            maxOverlap = Math.max(maxOverlap, currentOverlap); // 최대값 갱신
        }

        // 최대 겹치는 선분의 개수를 출력
        System.out.println(maxOverlap);
    }
}

// 선분의 시작과 끝을 나타내는 포인트 클래스
class Point {
    int x; // 좌표
    int type; // 시작이면 +1, 끝이면 -1

    public Point(int x, int type) {
        this.x = x;
        this.type = type;
    }
}