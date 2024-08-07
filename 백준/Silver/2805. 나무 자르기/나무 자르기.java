import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int left = 0;
        int right = -1;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]); // 나무의 최대 높이 이상으로는 자를 수 없기때문에 최대값 구하기
        }

        while (left <= right) { // left가 right를 넘어서기 전까지 반복
            int mid = (left + right) / 2;
            long tree = 0; // 범위를 초과해서 long
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    tree += trees[i] - mid;
                }
            }
            if (tree >= M) { // 너무 많이 가져갔거나 정확히 가져갔을 경우
                left = mid + 1;
            } else if (tree < M) { // 너무 적게 가져갔을 경우
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}