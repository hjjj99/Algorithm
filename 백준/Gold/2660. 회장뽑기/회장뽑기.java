import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static boolean edge[][];
    public static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        edge = new boolean[N+1][N+1];
        
        while(true){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            if(a==-1 && b==-1){
                break;
            }
            edge[a][b] = true;
            edge[b][a] = true;
        }

        int finalScore[] = new int[N+1];

        for(int i=1; i<=N; i++){
            int score = 0;
            for(int j=1; j<=N; j++){
                //i랑 j 사이 체크
                visited = new boolean[N+1];
                int nowScore = BFS(i, j);
                if(nowScore>score){
                    score = nowScore;
                }
            }
            finalScore[i] = score;
        }

        int minScore = Integer.MAX_VALUE;
        int minCount = 0;

        for(int i=1; i<=N; i++){
            if(minScore > finalScore[i]){
                minScore = finalScore[i];
                minCount=1;
            } else if(minScore == finalScore[i]){
                minCount++;
            }
        }

        System.out.println(minScore +" "+minCount);

        StringBuilder body = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(finalScore[i]==minScore){
                body.append(i+" ");
            }
        }

        System.out.println(body);
    }


    public static int BFS(int me, int friend){
        visited[me] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {me, 0});

        while(!q.isEmpty()){
            int n[] = q.poll();
            int next = n[0];
            int count = n[1];
            if(next == friend){
                return count;
            }
            for(int i=1; i<=N; i++){
                if((edge[next][i] || edge[i][next]) && !visited[i]){
                    q.add(new int[] {i, count+1});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}