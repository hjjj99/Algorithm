import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N==M){
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[100001];
        visited[N] = true; //현재 위치
        Queue<Integer> q = new LinkedList<>();
        q.add(N); //큐에도 현재 위치 저장
        int size = q.size();
        int count = 0;

        while(true){
            count++;
            size = q.size();
            for(int i=0; i<size; i++){
                int x = q.remove(); //q에서 제일 위에 있던거
                visited[x] = true;
                if(x-1 == M || x+1 == M || 2*x ==M){
                    System.out.println(count);
                    return;
                }
                if(x-1>=0 && !visited[x-1]){
                    visited[x-1] = true;
                    q.add(x-1);
                }
                if (x+1 <= 100000 && !visited[x+1]) {
                    visited[x+1] = true;
                    q.add(x+1);
                }
                if (x*2 <= 100000 && !visited[x*2]) {
                    visited[x*2] = true;
                    q.add(x*2);
                }
            
            }
            
        }



    }
}