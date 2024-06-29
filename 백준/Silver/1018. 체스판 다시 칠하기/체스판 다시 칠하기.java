import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//입력 보드
		String[] arr = new String[N];
		//흰보드와 검은보드
		String[] Wboard = new String[8];
		String[] Bboard = new String[8];
		
		//입력보드에 입력값 저장
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		//흰보드 만들기
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) Wboard[i] = "WBWBWBWB";
			else Wboard[i] = "BWBWBWBW";
		}
		
		//검은보드 만들기
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) Bboard[i] = "BWBWBWBW";
			else Bboard[i] = "WBWBWBWB";
		}
		
		//모든 경우의 수중 제일 작은 값을 저장할 변수. 최솟값을 비교하기 위해서 나올 수 있는 제일 큰 값을 저장.
		//8x8이기때문에 64가 제일 나올 수 있는 큰 수 이다.
		//(완전 다른 두 보드를 비교하기 때문에 사실상 유효한 수는 절반인 32이다.)
		int min = 64;
		
		//보드르 비교하기 위한 for문 4개.
		for(int i = 0; i < (N - 7); i++) {
			for(int j = 0; j < (M - 7); j++) {
				int Wcount = 0;
				int Bcount = 0;
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(Wboard[k].charAt(l) != arr[k + i].charAt(l + j)) Wcount++;
						if(Bboard[k].charAt(l) != arr[k + i].charAt(l + j)) Bcount++;
					}
				}
				min = Math.min(min, Math.min(Wcount, Bcount));
			}
		}
		System.out.println(min);
	}

}