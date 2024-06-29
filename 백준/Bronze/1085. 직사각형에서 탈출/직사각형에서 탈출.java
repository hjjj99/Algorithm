import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        br.close();

        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());
        int h = Integer.parseInt(token.nextToken());
        
        //직사각형의 경계선까지 가는 거리[w, h로 가는 거리가 아니다.]
        int x_axisMin = findMin(x, w-x);
        int y_axisMin = findMin(y, h-y);

        System.out.println(y_axisMin > x_axisMin ? x_axisMin : y_axisMin);
    }
        
    //최솟값을 찾는 메서드
    static int findMin(int m, int n){
        if(m >= n){
            return n;
        }else{ //m이 더 작을때
            return m;
        }
    }
}