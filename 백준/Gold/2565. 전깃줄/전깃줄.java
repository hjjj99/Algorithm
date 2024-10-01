import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, count;
    public static int line[][];
    public static boolean visited[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            line[i][0] = a;
            line[i][1] = b;
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int max = Integer.MIN_VALUE;
        
        //LIS 구하기
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;  // 자기 자신을 포함하는 최소 길이 1
            for (int j = 0; j < i; j++) {
                if (line[j][1] < line[i][1]) {  // B전봇대에서 교차하지 않는 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);  // 최장 증가 부분 수열의 길이 갱신
        }

        System.out.println(N-max);
    }

}