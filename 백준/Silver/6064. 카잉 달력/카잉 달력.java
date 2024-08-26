import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            boolean check = false;
            StringTokenizer str = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(str.nextToken()); 
            int N = Integer.parseInt(str.nextToken()); 
            int x = Integer.parseInt(str.nextToken())-1; 
            int y = Integer.parseInt(str.nextToken())-1; 
            
            for(int i=x; i<M*N; i+=M){
                if(i%N == y){
                    System.out.println(i+1);
                    check = true;
					break;
                }
            }

            if (!check) {
				System.out.println(-1);

			}


        }

        

    }
}