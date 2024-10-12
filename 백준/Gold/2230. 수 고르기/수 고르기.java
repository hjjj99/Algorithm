import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int i = 0; 
        int j = 0;
        int ans = Integer.MAX_VALUE;

        while(i<N){
            if (arr[i] - arr[j] < M) {
                i++;
                continue;
            }
 
            if (arr[i] - arr[j] == M) {
                ans = M;
                break;
            }

            ans = Math.min(ans, arr[i] - arr[j]);
            j++;

        }

        System.out.println(ans);
    }
}