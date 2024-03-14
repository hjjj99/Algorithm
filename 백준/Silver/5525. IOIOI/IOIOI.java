import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        //OI가 N개 들어가는지 확인하고, 앞에 I가 있는지를 확인하면 된다.
        int answer = 0;
        int[] memo = new int[M];
        char[] str = br.readLine().toCharArray();
        for(int i=1;i<M-1;i++){
            if(str[i]=='O' && str[i+1]=='I'){
                memo[i+1] = memo[i-1]+1;
                if(memo[i+1]>=N && str[i-2*N+1]=='I'){
                    answer++;
                }
            }
        } 
        System.out.println(answer);
    }
}