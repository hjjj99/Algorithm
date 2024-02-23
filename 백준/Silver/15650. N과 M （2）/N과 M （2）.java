import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int sel[] = new int[N];
    public static int num[] = new int[N];
    public static boolean visited[] = new boolean[N];

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[N];
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = i+1;
        }

        combination(0, 0);
    }

    public static void combination(int idx, int sidx){
        if(sidx==M){
            for(int i=0; i<M-1; i++){
                System.out.print(sel[i]+" ");
            }
            System.out.println(sel[M-1]);
            return;
        }
        if(idx == N){
            return;
        }
        sel[sidx] = num[idx];
        combination(idx + 1, sidx + 1); // idx 번째 재료 뽑은거
		combination(idx + 1, sidx); // idx 번째 재료 안뽑은거
    }
}