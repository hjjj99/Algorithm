import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<ArrayList<Integer>> list;
    static int ans[];
    static int N, M;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[N+1];

        list = new ArrayList<ArrayList<Integer>>();

        //리스트에 개수+1만큼 리스트 삽입
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<Integer>());
        }

        //연결 개수만큼
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //a리스트에 b삽입
            list.get(a).add(b);
        }

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            BFS(i);
        }

        int max = Integer.MIN_VALUE;
        
        //최댓값 찾기
        for(int i=1; i<=N; i++) {
            max = Math.max(max, ans[i]);
        }
        
        for(int i=1; i<=N; i++) {
            if(ans[i]==max) {
                System.out.print(i + " ");
            }
        }
        

    }

    public static void BFS(int i){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[i] = true;
        q.add(i);

        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int a : list.get(now)) {
                if(!visited[a]) {
                    visited[a] =true;
                    //현재 노드 now에서 a노드로 이동할 수 있다는 것은 
                    //now가 a를 신뢰한다는 뜻이다.
                    ans[a]++;
                    q.add(a);
                }
            }
        }
        
    }
}