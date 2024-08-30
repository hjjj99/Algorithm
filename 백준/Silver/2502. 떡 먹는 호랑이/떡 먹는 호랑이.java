import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        int[][] need = new int[D+2][2];

        //3ㅣㅇㄹ차에 필요한 것
        need[3][0] = 1;
        need[3][1] = 1;

        //4일차
        need[4][0] = 1;
        need[4][1] = 2;

        if(D>4){
            for(int i=5; i<=D; i++){
                need[i][0] = need[i-1][0]+need[i-2][0];
                need[i][1] = need[i-1][1]+need[i-2][1];
            }
        }

        int a = 1;

        while(true){
            if((K - need[D][0]*a) % need[D][1] == 0){
                System.out.println(a);
                System.out.println((K -= need[D][0]*a) / need[D][1]);
                break;
            } else{
                a += 1;
            }
        }

    }
}