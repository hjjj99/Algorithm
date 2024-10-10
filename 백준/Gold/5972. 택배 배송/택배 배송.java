import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int index;
	int cost;
	
	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}

public class Main {
    public static int N, M;
    public static ArrayList<Node>[] graph;
    public static boolean visited[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)  graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        System.out.println(find(1));
    }

    public static int find(int idx){
         
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[idx] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(idx, 0));
        
        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;

            //index와 연결된 정점 비교
            for(Node next : graph[nowVertex]){
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[N];
    }
}