import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(str.nextToken());
        }

        int max = num[0];
        int currentSum = num[0];

        for (int i = 1; i < N; i++) {
            currentSum = Math.max(num[i], currentSum + num[i]);
            max = Math.max(max, currentSum);
        }

        System.out.println(max);
    }
}