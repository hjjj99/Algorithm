import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num[];
    static Boolean sel[];
    static int sum = 0;
    static int N, S;
    static int result = 0;

    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        // 배열 초기화
        num = new int[N];
        sel = new Boolean[N];

        for(int i=0; i<N; i++){
            sel[i] = false;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        // 부분 수열로 나누기
        Check(0);
        if(S == 0) {
			result --;
		}
        System.out.println(result);
    }

    public static void Check(int a){
        if(a==num.length){
            sum = 0;
            for(int i=0; i<N; i++){
                if(sel[i] == true){
                    sum += num[i];
                }
            }
            if(sum==S){
                result++;
            }
            return;
        }

        // 선택여부 체크
        sel[a] = true;
        Check(a+1);
        sel[a] = false;
        Check(a+1);
    }
}