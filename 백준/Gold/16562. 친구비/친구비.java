import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K, cost[], parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        cost = new int[N + 1];  // 비용 배열
        parent = new int[N + 1];  // 부모 배열
        makeSet();  // 부모 배열 초기화

        str = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(str.nextToken());
        }

        // 친구 관계를 통해 유니온 작업을 수행
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            union(a, b);
        }

        long totalCost = 0;
        boolean[] checked = new boolean[N + 1];

        // 각 그룹의 최소 비용만 누적하여 계산
        for (int i = 1; i <= N; i++) {
            int root = find(i);
            if (!checked[root]) {
                totalCost += cost[root];
                checked[root] = true;
            }
        }

        // 필요한 비용이 가진 돈을 넘어서면 "Oh no"를 출력하고, 아니면 필요한 최소 비용을 출력
        if (totalCost > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(totalCost);
        }
    }

    // 부모 배열 초기화 함수
    public static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    // 두 학생을 같은 그룹으로 묶는 유니온 함수
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // 비용이 더 작은 쪽을 루트로 설정하여 그룹을 묶음
        if (rootX != rootY) {
            if (cost[rootX] < cost[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }

    // x의 루트를 찾는 함수. 경로 압축을 사용해 효율적으로 루트를 찾음
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}