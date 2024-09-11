import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(num);

        int L = 0; 
        int R = N - 1;
        int min = Integer.MAX_VALUE;
        int minx = 0;
        int miny = 0;
        
        while(L<R){
            int sum = num[L] + num[R];

            if(Math.abs(min) > Math.abs(sum)){
                min = sum;
                minx = num[L];
                miny = num[R];
                if(sum == 0){
                    break;
                }
            }
            if(sum<0){
                L++;
            }
            else{
                R--;
            }
        }

        System.out.println(minx+" "+miny);
    }
}