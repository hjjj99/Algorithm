import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //N과 M입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //변수 설정
        arr = new int[N];
        visit = new boolean[N];
        result = new int[M];

        //N개의 수 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(arr);

        dfs(N, M, 0);

        System.out.print(sb);
    }

    public static void dfs(int n, int m, int depth){

        if(m == depth) {
            for(int var: result)
                sb.append(var + " ");
            sb.append("\n");
        }

        else{
            int before = 0;
            for(int i = 0; i < n; i++){
                if(visit[i] == false){
                    if(before != arr[i]) {
                        visit[i] = true;
                        before = arr[i];
                        result[depth] = arr[i];
                        dfs(n, m, depth + 1);
                        visit[i] = false;
                    }
                }
            }
        }
    }
}