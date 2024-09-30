import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        //집의 개수
        int N = Integer.parseInt(str.nextToken());
        //공유기 개수
        int C = Integer.parseInt(str.nextToken());

        int home[] = new int[N];
        for(int i=0; i<N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int L = 1;
        int R = home[N-1] - home[0];
        int maxDist = 0; // 최종 답 저장

        while(L<=R){
            int mid = (L+R)/2;
            int count = 1; // 첫 번째 집에는 항상 공유기를 설치
            int lastInstalled = home[0];
            for(int i=1; i<N; i++){
                if (home[i] - lastInstalled >= mid) { // 현재 집과 마지막 설치 집의 거리가 mid 이상이면 설치
                    count++;
                    lastInstalled = home[i]; // 공유기 설치
                }
            }

            // 설치된 공유기의 개수가 C개 이상인 경우, 거리를 늘려본다
            if (count >= C) {
                maxDist = mid; // 가능한 최대 거리 갱신
                L = mid + 1; // 거리를 더 늘림
            } else {
                R = mid - 1; // 거리를 줄임
            }
        }

        System.out.println(maxDist);
    }
}