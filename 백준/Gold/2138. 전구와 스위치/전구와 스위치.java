import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		String fromStr = br.readLine();
		String toStr = br.readLine();

		boolean[] from = new boolean[N];
		boolean[] to = new boolean[N];

		for (int i = 0; i < N; i++) {
			from[i] = fromStr.charAt(i) == '1';
			to[i] = toStr.charAt(i) == '1';
		}

		// 스위치를 순차적으로 누르면, 누른 스위치의 직전 전구의 상태가 확정됨
		// 첫 번째 스위치를 켜는 경우와 켜지 않는 경우로 구분
		int answer = Integer.MAX_VALUE;

		// 1. 첫 번째 스위치를 켜는 경우
		int case1 = 1;

		boolean[] temp = from.clone();
		pushSwitch(temp, 0);

		for (int i = 1; i < N; i++) {
			if (temp[i - 1] != to[i - 1]) {
				pushSwitch(temp, i);
				case1++;
			}
		}

		if (temp[N - 1] != to[N - 1])
			case1 = Integer.MAX_VALUE;

		// 2. 첫 번째 스위치를 켜지 않는 경우
		int case2 = 0;

		temp = from.clone();

		for (int i = 1; i < N; i++) {
			if (temp[i - 1] != to[i - 1]) {
				pushSwitch(temp, i);
				case2++;
			}
		}

		if (temp[N - 1] != to[N - 1])
			case2 = Integer.MAX_VALUE;

		// 두 경우 비교
		answer = Math.min(case1, case2);

		sb.append(answer == Integer.MAX_VALUE ? -1 : answer);
		System.out.println(sb);
	}

	public static void pushSwitch(boolean[] arr, int i) {
		arr[i] = !arr[i];

		if (i > 0)
			arr[i - 1] = !arr[i - 1];

		if (i < N - 1)
			arr[i + 1] = !arr[i + 1];
	}
}