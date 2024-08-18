import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            //맨 앞 출력
            System.out.println(q.poll());
            if(q.size()>1){
                //맨 앞 또 뺴서
            int n = q.poll();
            //맨 뒤에 넣기
            q.add(n);
            }
            
            
        }
    }
}