import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int board[][];
    public static int count1, count2;
    public static int dx[] = {0, 1, 0, 1};
    public static int dy[] = {0, 0, 1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        count1 = 0;
        count2 = 0;

        count(N, 0, 0);

        
        System.out.println(count2);
        System.out.println(count1);
    }

    public static void count(int K, int x, int y){

        boolean allsame = true;
        int before = board[x][y];

        for(int i=x; i<x+K; i++){
            for(int j=y; j<y+K; j++){
                if(before != board[i][j]){ 
                    allsame = false;
                }
            }
        }

        if(allsame){
            if(board[x][y]==1){
                count1 ++;
            } else{
            count2 ++;
            }
            return;
        }  else{
            int next = K/2;
            for(int i=0; i<4; i++){
                int nx = x + dx[i]*next;
                int ny = y + dy[i]*next;
                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    count(K/2, nx, ny);
                }
            }
        }
    
            
        

    }


}