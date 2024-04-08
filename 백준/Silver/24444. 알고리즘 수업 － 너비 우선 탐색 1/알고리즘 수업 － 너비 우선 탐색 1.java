import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static int N, M, R;
    public static boolean visited[];
    public static int result[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        R = Integer.parseInt(str.nextToken());
        result = new int[N+1];

        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        while(M-- >0){
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());
            arr[u].add(w);
            arr[w].add(u);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(arr[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        int count = 1;
        result[R] = count;

        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int i=0; i<arr[x].size(); i++){
                int h = arr[x].get(i);
                if (result[h] == 0){
                    count ++;
                    result[h] = count;
                    queue.add(h);
                }
            }
        }

        for(int i=1; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

}