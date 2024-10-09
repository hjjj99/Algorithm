import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(); //차량이 터널로 들어간 순서 저장하는 맵

        //들어간 순서 저장
        for (int i = 1; i <= N; i++) {
            map.put(br.readLine(), i);
        }

        //나온 차량을 순서대로 저장
        String[] out = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            out[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        //나온 순서를 뒤에서부터 확인
        for (int i = N; i >= 1; i--) {
            int cur = map.get(out[i]);
            if (cur < min) {
                min = cur; //현재까지 가장 빠른 순서 갱신 (min에 저장)
            }
            if (cur > min) {
                count++; //현재의 min보다 큰 값(뒷 순서)가 나오면 추월했다는 의미이므로 count 증가
            }
        }
        System.out.println(count);
    }
}