import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node> {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int N, E;
    public static ArrayList<Node>[] adjList;
    public static final int INF = 200000000; // 충분히 큰 값
    public static int[] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        E = Integer.parseInt(str.nextToken());

        adjList = new ArrayList[N + 1];
        cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        str = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(str.nextToken());
        int must2 = Integer.parseInt(str.nextToken());

        // 경로 1: 1 -> must1 -> must2 -> N
        int path1 = dijkstra(1, must1) + dijkstra(must1, must2) + dijkstra(must2, N);
        // 경로 2: 1 -> must2 -> must1 -> N
        int path2 = dijkstra(1, must2) + dijkstra(must2, must1) + dijkstra(must1, N);

        int result = Math.min(path1, path2);

        // 경로가 존재하지 않을 경우 INF보다 크면 -1 출력
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(cost, INF); // 비용 배열 초기화
        cost[start] = 0; // 시작점은 0

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 현재 노드가 도착지일 때 바로 반환
            if (now.dest == end) {
                return cost[end];
            }

            // 인접한 노드들 확인
            for (Node next : adjList[now.dest]) {
                int newCost = cost[now.dest] + next.cost;

                // 더 짧은 경로가 발견되었을 때만 업데이트
                if (newCost < cost[next.dest]) {
                    cost[next.dest] = newCost;
                    pq.add(new Node(next.dest, newCost));
                }
            }
        }

        return cost[end]; // 도착 노드로의 최단 거리 반환
    }
}