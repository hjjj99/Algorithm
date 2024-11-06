import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        num = new int[N+1];

        for(int i=1; i<=N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            //1,1 / 2,2 / 3,3 / 4,4 / 5,5 
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list); //작은 수 부터 출력하므로 정렬한다.
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int start, int target) {
        if(visited[num[start]] == false) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }
        if(num[start] == target) list.add(target); //사이클 발생시 해당 숫자를 list에 담아준다.
    }
}