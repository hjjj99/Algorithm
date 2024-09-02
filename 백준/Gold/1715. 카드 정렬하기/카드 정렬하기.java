import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while(pq.size()>1){
            int sum = 0;
            for(int i=0; i<2; i++){
                sum += pq.poll();
            }
            pq.add(sum);
            answer += sum;
        }

        System.out.println(answer);

    }
}