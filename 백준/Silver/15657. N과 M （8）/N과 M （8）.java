import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] num, sel;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        num = new int[N];
        sel = new int[M];
        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(num);

        DFS(0, 0);
    }

    public static void DFS(int idx, int sidx){
        if(sidx == M){
            for(int i=0; i<M; i++){
                System.out.print(sel[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=idx; i<N; i++){
            sel[sidx] = num[i];
            DFS(i, sidx+1);
        }

    }
}