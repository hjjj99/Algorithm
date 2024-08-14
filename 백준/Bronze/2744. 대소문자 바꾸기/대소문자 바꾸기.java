import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if('A'<=ch && ch<='Z'){
                System.out.print((char)('a'+ch-'A'));
            } else {
                System.out.print((char)('A'+ch-'a'));
            }
        }
    }
}