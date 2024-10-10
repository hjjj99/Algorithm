import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static String S, T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        System.out.println(check(T));
    
    }
    public static int check(String str){
        if (str.equals(S)) {
            return 1;
        }
        if (str.length() <= S.length()) {
            return 0;
        }

        int result = 0;

        // 뒤에 A를 제거하고 재귀적으로 검사
        if (str.charAt(str.length() - 1) == 'A') {
            result = check(str.substring(0, str.length() - 1));
        }

        // 앞에 B를 제거하고 뒤집은 후 재귀적으로 검사
        if (result == 0 && str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str.substring(1)).reverse();
            result = check(sb.toString());
        }

        return result;
    }
}