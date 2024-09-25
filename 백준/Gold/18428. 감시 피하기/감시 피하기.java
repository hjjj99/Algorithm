import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static char map[][];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = str.nextToken().charAt(0);
            }
        }

        DFS(0);
        System.out.println("NO");

    }
    static void DFS(int depth){
        //3개 골랐다
        if (depth == 3) {
            // 선생님에게 감시당하지 않는지 확인
            if (BFS()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'X'){
                    map[i][j] = 'O';
                    DFS(depth+1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static boolean BFS(){
        Queue<int[]> teacher = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'T'){
                    teacher.add(new int[] {i, j});
                }
            }
        }
        while(!teacher.isEmpty()){
            int[] now = teacher.poll();
            for(int i=0; i<4; i++){
                int nx = now[0];
                int ny = now[1];
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    // 경계 내에 있을 때만 탐색
                    if(nx<0 || ny<0 || ny>=N || nx>=N) break;
                    if (map[nx][ny] == 'O') break; 
                    if (map[nx][ny] == 'S') return false;
                }
            }
        }
        return true;
    }

    // //각 학생이 선생님에게 감시당하는지 확인
    // static boolean checkStudent(boolean[][] check){
    //     for(int i=0; i<N; i++){
    //         for(int j=0; j<N; j++){
    //             if (map[i][j] == 'S' && check[i][j]) {
    //                 return false; // 학생이 감시당하는 경우
    //             }
    //         }
    //     }
    //     return true;
    // }

    

}