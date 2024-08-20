import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int num[], sel[];
    public static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        sel = new int[N];
        visited = new boolean[N+1];

        perm(0);

    }

    public static void perm(int idx){
        if(idx==N){
            for(int i=0; i<N; i++){
                System.out.print(sel[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[idx] = i;
                perm(idx+1);
                visited[i]=false;
            }
        }
    }
}