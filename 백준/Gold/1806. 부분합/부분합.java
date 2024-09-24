import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int S = Integer.parseInt(str.nextToken());

        int num[] = new int[N+1];

        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(str.nextToken());
        }

        int sum = 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int length = 0;
        
        while(right<=N){
            if(sum >= S){
                sum -= num[left++];
				length = right - left + 1; // 길이를 구하기
				if(min > length) min = length; // 길이의 최솟값
            } else if (sum < S){
                sum += num[right++];
            }
        }

        
        System.out.println((min) == Integer.MAX_VALUE ? 0 : min);
    }
}