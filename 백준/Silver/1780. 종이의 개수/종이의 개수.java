import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int map[][];
    public static int answer1 = 0;
    public static int answer2 = 0;
    public static int answer3 = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        solve(0, 0, N);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

    }

    public static void solve(int x, int y, int size){
        //그 칸이 다 동일하다면
        if(check(x, y, size)){
            int num = map[x][y];
            if(num == -1){
                answer1 ++;
            }
            if(num == 0){
                answer2++;
            }
            if(num == 1){
                answer3++;
            }
            return;
        }

        int newSize = size/3;
        for(int i=x; i<x+size; i+=newSize){
            for(int j=y; j<y+size; j+= newSize){
                solve(i, j, newSize);
            }
        }
    }

    public static boolean check(int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(map[x][y] != map[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}