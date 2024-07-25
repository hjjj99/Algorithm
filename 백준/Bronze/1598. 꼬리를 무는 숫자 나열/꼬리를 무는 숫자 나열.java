import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
        //A B 두 값중 크고 작은 값을 변수에 넣어준다.
		int N = Math.min(A, B);
		int M = Math.max(A, B);
		int count = 0;
		
        //무한반복문으로 조건 충족할때까지 반복
		while(true) {
        	//오른쪽으로 이동하는 반복문이기 때문에 한칸 이동할때마다 최솟값에 4를 더해준다.
           	//count는 이동한 횟수
			N += 4;
			count++;
            //N과 M 값이 가로로 같은 경로에 있으면 4를 더하다 보면 같은 값이 된다. 그때 종료.
			if(N == M) {
				break;
			}
            //최대값을 4로 나눈 나머지가 0일떄와 아닐때 범위 식이 달라지기 때문에 나눠 조건을 단다.
			if((M % 4) == 0 && M - 3 <= N && N <= M) {
				break;
			}
			if((M % 4) != 0 && (1 + ((M / 4) * 4)) <= N && N <= (((M / 4) + 1) * 4)) {
				break;
			}
            //위 조건들에 부합하지 않으면서 N에 4를 더했을때 M을 넘어가는 경우가 있다.
            //그런경우에는 N에서 4를 다시 빼주고 count에서도 1을 뺀다.그리고 반복문 종료
			if(N > M) {
				count--;
				N -= 4;
				break;
			}
		}
        //가로로 이동한 횟수를 구했으니 세로로 이동할 휫수를 더해준다.
        //두 수중 어느 수가 큰 수 인지 않 수 없으니 빼주고 절대값으로 계산한다.
		count += Math.abs(M - N);
		System.out.println(count);
	}

}