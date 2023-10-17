import java.util.Scanner;

public class Main {
	static long p[] = new long[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			if(N<=5) {
				System.out.println(p[N]);
			}
			
			else {
				for(int i=6; i<=N; i++) {
					p[i] = p[i-1] + p[i-5];
				}
				System.out.println(p[N]);
			}
			
		}
	}
}