import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//입력값들을 저장 할 배열
		String[] arr = new String[N];
		
		//입력값들을 배열에 저장
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		//배열의 값들의 같은 인덱스에 있는 값들을 비교할 반복문과 조건문
		for(int i = 0; i < arr[0].length(); i++) {
			//최종 출력할때 인덱스에 있는 값을 출력할지, ?를 출력할지 구분하기 위한 정수형 변수
			int count = 0;
			for(int j = 0; j < (N - 1); j++) {
				if(arr[j].charAt(i) != arr[j + 1].charAt(i)) {
					break;
				}
				count++;
			}
			if(count == (N - 1)) {
				System.out.print(arr[0].charAt(i));
			}else {
				System.out.print("?");
			}
		}
	}

}