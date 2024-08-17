import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num[] = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(str.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int l = 0;
        int r = N-1;
        int sum = 0;
        int count = 0;

        Arrays.sort(num);

        while (l<r){
            sum = num[l] + num[r];
            
            if(sum == M){
                count ++;
                l++;
                r--;
            } else if(sum > M){
                r--;
            } else{
                l++;
            }
        }

        System.out.println(count);
    }
}