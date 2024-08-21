import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        //3
        int n = Integer.parseInt(str.nextToken());
        //5
        int m = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        int map[][] = new int[n+1][m+1];

        //1
        int stopx = k/m;
        //3-1
        int stopy = k%m;

        if(stopy != 0){
            stopy -= 1;
        }


        for(int i=0; i<=stopx; i++){
            map[i][0] = 1;
        }

        for(int i=0; i<=stopy; i++){
            map[0][i] = 1;
        }

        for(int i=1; i<=stopx; i++){
            for(int j=1; j<=stopy; j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }

        for(int i=stopx; i<=n-1; i++){
            map[i][stopy] = map[stopx][stopy];
        }

        for(int i=stopy; i<=m-1; i++){
            map[stopx][i] = map[stopx][stopy];
        }

        for(int i=stopx+1; i<=n-1; i++){
            for(int j=stopy+1; j<=m-1; j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }

        System.out.println(map[n-1][m-1]);

    }
}