import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Location> customer = new ArrayList<>();
    static ArrayList<Location> chicken = new ArrayList<>();
    static boolean[] open;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 도시의 정보
        M = Integer.parseInt(st.nextToken());       // 최대 치킨집의 개수

        map = new int[N][N];

        /**
         * map에 도시의 정보를 담은 후,
         * 집이라면 customer에 좌표를 추가하고 치킨집이라면 chicken에 좌표를 추가한다.
         * 나중에 이 좌표들을 각각 꺼내서 치킨거리를 계산할 것이다!
         */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) customer.add(new Location(i, j));
                else if (map[i][j] == 2) chicken.add(new Location(i, j));
            }
        }

        open = new boolean[chicken.size()];     // 활성화된 치킨집을 구분하기 위한 배열

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int num, int depth) {
        if (depth == M) {
            int cnt = 0;

            /**
             * customer와 chicken에 각각 저장된 좌표들을 꺼내서 치킨 거리를 계산하고 최솟값을 카운팅!
             */
            for (int i = 0; i < customer.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) { //조합을 통해 open 여부를 설정해놨음
                        int distance = Math.abs(customer.get(i).x - chicken.get(j).x) + Math.abs(customer.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }
                cnt += temp;
            }
            min = Math.min(min, cnt);
        }

        /**
         * 조합을 구하는 방법에 따라 백트래킹을 구현한다.
         * [1, 2, 3, 4] 배열이 있고 depth = 2 라면
         * [1, 2] [1, 3] [1, 4] [2, 3], [2, 4] [3, 4] 를 구하는 것처럼 치킨집을 M만큼 모든 조합으로 돌리는 것이다.
         */
        for (int i = num; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i+1, depth+1);
            open[i] = false;
        }
    }


    public static class Location {
        int x, y;
        public Location(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}