import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;   //수빈
    static int s;   //동생
    public static boolean visited[];
    static int max = 100000;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        n = Integer.parseInt(str.nextToken());
        s = Integer.parseInt(str.nextToken());
        visited = new boolean[max+1];

        BFS();
        System.out.println(min);
    }

    public static void BFS(){

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.time - o2.time));
        queue.add(new Node(n,0));   //수빈의 위치에서 시작함

        while (!queue.isEmpty()){

            //방문할 노드
            Node now = queue.poll();
            visited[now.v] = true;

            //동생 있는곳에 도착하면
            //걸린 시간이 최소인지 확인
            if(now.v == s) min = Math.min(min, now.time);

            //순간이동
            if(now.v * 2 <= max && !visited[now.v * 2]) queue.add(new Node(now.v * 2, now.time));
            //걸어서
            if(now.v + 1 <= max && !visited[now.v + 1]) queue.add(new Node(now.v + 1, now.time+1));
            if(now.v - 1 >= 0 && !visited[now.v - 1]) queue.add(new Node(now.v - 1, now.time + 1));
        }
    }

    static class Node {
        int v;
        int time;

        public Node(int v, int time){
            this.v = v;
            this.time = time;
        }
    }
}