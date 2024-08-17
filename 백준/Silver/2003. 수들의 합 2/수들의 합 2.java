import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int[] A = new int[N];
        
        //수열 A
        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(str.nextToken());
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;

        while(true){
            //합이 목표보다 크면 왼쪽 포인터 옮기기
            if(sum >= M){
                sum -= A[l++];
            }
            //오른쪽 포인트가 길이에 도달하면
            else if (r == N){
                break;
            }
            //오른쪽 포인터를 증가시키면서 탐색
            else {
                sum += A[r++];
            }
            if(sum == M){
                count ++;
            }
        }

        System.out.println(count);

    }
}