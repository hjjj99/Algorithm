import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        int medal[][] = new int[N][3];

        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(str.nextToken());
            medal[num-1][0] = Integer.parseInt(str.nextToken());
            medal[num-1][1] = Integer.parseInt(str.nextToken());
            medal[num-1][2] = Integer.parseInt(str.nextToken());
        }

        int sum[] = new int[N];

        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                sum[i] += medal[i][0] * 100;
                sum[i] += medal[i][1] * 10;
                sum[i] += medal[i][2];
            }
        }


        int sumK = sum[K-1];
   
        
        int count = 0;
        for(int i=0; i<N; i++){
            if(sum[i] >sumK){
                count ++;
            }
        }
        
        System.out.println(count+1);
    }
}