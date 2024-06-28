import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            long answer = 0;

            StringTokenizer str = new StringTokenizer(br.readLine());
            int num[] = new int[N];
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(str.nextToken());
            }

            int max = num[N-1];

            for(int j=N-2;j>=0;j--) {
                if(num[j] <= max)	//가장 큰 시세보다 작은 시세일 때 판매!
                    answer += max - num[j];
                else		//가장 큰 시세보다 큰 시세 탐색시 바꾸기
                    max = num[j];
            }
            bw.write(answer + "\n");	
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    
    }
}