import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int num[][] = new int[N][2];
            for(int i=0; i<N; i++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                num[i][0] = Integer.parseInt(str.nextToken());
                num[i][1] = Integer.parseInt(str.nextToken());
            }

            //1. 서류 순위 기준 정렬
            Arrays.sort(num, (o1, o2)-> {
                return o1[0]-o2[0];
            });

            int answer = 1;
            int min = num[0][1]; //1등의 면접 순위 //이거보단 잘받아야됨

            for(int i=1; i<N; i++){ //
                if(num[i][1]<min){ //1등보다 면접 순위 높다
                    answer++;
                    min = num[i][1];
                }
            }

            System.out.println(answer);

        }
    
    }
}