import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//우선 배열을 이용할 건데 출근 / 최근 / 근무 시간이 들어갈 배열을 만든다.
		int[] arr = new int[3];
		int[] arr2 = new int[3];
		int[] arr3 = new int[3];
		
		//총 3명의 시간을 구하기 위해 3번 반복하는 for문을 만든다.
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//아래 3개의 for문은 각자 출근 시간 퇴근 시간 근무시간을 입력하고 구하는 반복문
			for(int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < 3; j++) {
				arr2[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 2; j >= 0; j--) {
				if(arr2[j] < arr[j]) {
					arr2[j - 1] -= 1;
					arr2[j] += 60;
				}
				arr3[j] = arr2[j] - arr[j];
			}
			//근무시간을 구했으니 그것을 출력 할 반복문
			for(int j = 0; j < 3; j++) {
				System.out.print(arr3[j] + " ");
			}
			System.out.println();
		}
	}

}