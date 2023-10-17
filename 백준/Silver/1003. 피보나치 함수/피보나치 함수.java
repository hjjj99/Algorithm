import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		long countZero[] = new long [41];
		long  countOne[] = new long [41];
		countZero[0] = 1;
		countZero[1] = 0;
		countOne[0] = 0;
		countOne[1] = 1;
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			if(N<=1) {
				System.out.println(countZero[N]+" "+countOne[N]);
			}
			else {
				for(int i=2; i<=N; i++) {
					countZero[i] = countZero[i-2] + countZero[i-1];
					countOne[i] = countOne[i-2] + countOne[i-1];
				}
				System.out.println(countZero[N]+" "+countOne[N]);
			}
		}
	}
}