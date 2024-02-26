import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int value[] = new int[N];
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(br.readLine());
        }
        int now = K;
		int result = 0;
		//원하는 가치의 합이 딱 맞을때까지 반복
		while(now != 0) {
			for(int i = N - 1; i >= 0; i--) {
				if(now >= value[i]) {
					result += (now / value[i]);
					now %= value[i];
					if(now < value[0] && now != 0) {
						result = 0;
						now = K;
					}
				}
			}
		}
		System.out.println(result);

    }
}