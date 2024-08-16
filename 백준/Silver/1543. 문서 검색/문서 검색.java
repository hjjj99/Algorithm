import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();

        int answer =0;

        while(str.contains(str2)){
            str = str.substring(str.indexOf(str2)+str2.length(), str.length());
            answer++;
        }

        System.out.println(answer);
    }
}