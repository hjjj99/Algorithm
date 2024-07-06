import java.io.*;

public class Main {

    public static BufferedReader br;

    public static int n;	// 과일의 수
    public static int[] arr;	// 과일의 배열상태 저장
    public static int[] cntFruit;	// 과일종류별로 몇 개 골랐는지 저장

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cntFruit = new int[10];

        String tmp = br.readLine();
        for (int i = 0; i < n ; i++) {
            arr[i] = tmp.charAt(i << 1) - '0';
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sol(0, 0, 0, 0, 0)));
        bw.close();
    }

    private static int sol(int left, int right, int cnt, int kind, int max) {
        // 우측 포인터가 배열의 마지막에 도달하면 return
        if (right == n) {
            return max;
        }
        // 우측 포인터가 새로 도달한 과일이 새로운 과일이면 종류 수 증가
        if (cntFruit[arr[right]] == 0) {
            kind++;
        }
        // 도달한 과일 수 및 배열 길이 증가
        cntFruit[arr[right]]++;
        cnt++;
        // 과일 종류가 3개 이상이면 왼쪽 포인터를 이동
        if (kind > 2) {
            cntFruit[arr[left]]--;	// 왼쪽 포인터가 가리켰던 과일 수 -1
            cnt--;	// 배열 길이 감소
            if (cntFruit[arr[left]] == 0) {
                kind--;		// 왼쪽 포인터가 가리켰던 과일이 하나 남았었다면 종류 -1
            }
            left++;		// 왼쪽 포인터 이동
        }
        // 최댓값 갱신
        max = Math.max(cnt, max);
        // 재귀
        return sol(left, right + 1, cnt, kind, max);
    }
}