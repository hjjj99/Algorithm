import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = 1;

        while(A != B){
            if(B%2 == 0){ //짝수면
                B = B/2;
                result++;
            }
            //홀수면 끝의 자리수가 1이면
            else if(B%10 == 1) { 
                B = (B-1)/10;
                result++;
            }
            else {
                System.out.println("-1");
                return;
            }
            if( B < A ) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);
        
    }
}