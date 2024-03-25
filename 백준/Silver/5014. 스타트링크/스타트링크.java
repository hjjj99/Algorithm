import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] count = new int[F+1]; // 움직임 횟수 확인 용도
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[F+1];
		
        //시작점 큐에 넣기
		q.add(S);
		check[S] = true; // 방문한 층 확인 용도
		count[S] = 0;
		
		// 해당 반복문 내에서 계속 큐를 삽입, 꺼내는 작업이 진행된다. → 모든 층 탐색
		while(!q.isEmpty()) { // 모든 층을 방문했거나 목표층 도달 시 탈출
			
			int pull = q.poll(); // 가장 오래 저장된 큐 값 꺼내기
			
			if(pull == G) { // 목표층 도달
				System.out.println(count[pull]);
				return;
			}
			
			for(int i=0; i<2; i++) {
				
				int next = 0; // 현재 층에서 증가했을 대와 감소했을 때 탐색
				if(i==0) next = pull + U; 
				else next = pull - D; 
				
				if(next > F || next < 1) continue; // 층 범위를 벗어나면
				
				if(!check[next]) { // 방문하지 않은 층일 경우
					check[next] = true; 
					q.add(next); // 해당 층을 방문하기 위해 큐에 값 넣기
					count[next] = count[pull] +1; 
				}
			}
		}
		System.out.println("use the stairs");
	}
}