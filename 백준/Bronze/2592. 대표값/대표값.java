import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num[] = new int[10];
        int count[] = new int[1001];
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            num[i] = Integer.parseInt(br.readLine());
            count[num[i]]++;
            sum += num[i];
        }

        int avg = sum / 10;
        int max = Integer.MIN_VALUE;
        int maxvalue = 0;

        for (int i = 0; i < 1001; i++) {
            if (max < count[i]) {
                max = count[i];
                maxvalue = i;
            }
        }

        System.out.println(avg);
        System.out.println(maxvalue);

    }
}