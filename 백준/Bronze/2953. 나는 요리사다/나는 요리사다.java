import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score[][] = new int[5][4];
        int sum[] = new int[5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                score[i][j] = Integer.parseInt(str.nextToken());
                sum[i] += score[i][j];
            }
        }

        int win = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 5; i++) {
            if (sum[i] >= max) {
                max = sum[i];
                win = i + 1;
            }
        }

        System.out.print(win + " " + sum[win - 1]);
    }
}