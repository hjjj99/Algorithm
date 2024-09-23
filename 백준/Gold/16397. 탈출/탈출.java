import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int N, T, G;

	public static int bfs() {
		boolean chk[] = new boolean[100000];
		Queue <int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		chk[N] = true;
		
		while(!q.isEmpty()) {
			int num[] = q.poll();
			
			if(num[1] > T) return -1;
			if(num[0] == G) return num[1];
			
			int tmp = num[0] + 1; // A 버튼
			if(tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[] {tmp, num[1] + 1});
			}
			
			tmp = num[0] * 2; // B 버튼
			if(tmp > 99999) continue; // 99999 넘으면 스킵
			String st = Integer.toString(tmp);
			tmp -= (int)Math.pow(10, st.length() - 1);
			if(tmp >= 0 && tmp < 100000 && !chk[tmp]) {
				chk[tmp] = true;
				q.offer(new int[] {tmp, num[1] + 1});
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); T = sc.nextInt(); G = sc.nextInt();
		
		int res = bfs();
		if(res == -1) System.out.println("ANG");
		else System.out.println(res);
	}
}