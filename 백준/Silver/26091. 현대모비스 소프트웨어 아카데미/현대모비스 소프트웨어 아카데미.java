import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static int N, M;
    public static int num[];
    public static boolean visited[]; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        num = new int[N];
        visited = new boolean[N];

        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(str.nextToken());
        }

        int count = 0;

        Arrays.sort(num);

        int i=0;
        int j=N-1;

        while(i< j){
            if(num[i]+num[j]>=M){
                    count ++;
                    i++;
                    j--;
                }
                else{
                    i++;
                }
        }
                
            

        System.out.println(count);
        
    }
}