import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int[] start = { 2, 3, 5, 7 }; // 1의 자리 시작 할 수 있는 값 배열
    static int[] num = { 1, 3, 5, 7, 9 }; // 1의 자리 이후 다음 올 수 있는 홀수들
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        // 각 N자리가 {2, 3, 5, 7}로 시작할 때 탐색!
        for (int i = 0; i < start.length; i++)
            search(1, start[i]);
        bw.write(answer.toString()); // 관심있는 소수들 BufferedWriter 저장
        bw.flush(); // 결과 출력
        bw.close();
        br.close();
    }

    // N의 자리를 소수인지 판별해 나아가며 탐색하는 함수
    static void search(int idx, int value) {
        if (primeCheck(value)) // 소수인지 확인
            return; // 소수가 아닐 때 Return

        // 관심있는 소수 완성!
        if (idx == N) {
            answer.append(value).append("\n");
            return;
        }
        // 홀수 값들 추가해나아가며 탐색
        for (int i = 0; i < num.length; i++)
            search(idx + 1, value * 10 + num[i]);
    }

    // √제곱근 이하의 값으로 나누어 떨어지는지 확인하여 소수인지 파악하는 함수!
    static boolean primeCheck(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return true;
        return false;
    }
}