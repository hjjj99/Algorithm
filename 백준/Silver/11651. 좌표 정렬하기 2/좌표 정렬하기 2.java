import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[][] = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            num[i][1] = Integer.parseInt(str.nextToken());
            num[i][0] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(num, (o1, o2) ->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            } else{
                return o1[0]-o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			// 위치 주의
			sb.append(num[i][1] + " " + num[i][0]).append('\n');
		}
		System.out.println(sb);
    }
}