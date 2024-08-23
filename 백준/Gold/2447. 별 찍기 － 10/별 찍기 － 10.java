import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static String answer[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        answer = new String[N][N];

        
        stamp(0, 0, N);
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                // null 상태로 있는 빈공간을 채워주기
                bw.write(answer[i][j] != null ? answer[i][j] : " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void stamp(int x, int y, int size){
        if(size == 1){
            answer[x][y] = "*";
            return;
        }
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!(i==1 && j==1))
                    stamp(x+i*size/3, y+j*size/3, size/3);
            }
        }
    }
}