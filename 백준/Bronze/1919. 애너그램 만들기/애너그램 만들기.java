import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int eng1[] = new int[26];
        int eng2[] = new int[26];

        for(int i=0; i<str1.length(); i++){
            char c = str1.charAt(i);
            eng1[c-'a']++;
        }

        for(int i=0; i<str2.length(); i++){
            char c = str2.charAt(i);
            eng2[c-'a']++;
        }

        int answer = 0;
        for(int i=0; i<26; i++){
            if(eng1[i] != eng2[i]){
                answer += Math.abs(eng1[i]-eng2[i]);
            }
        }

        System.out.println(answer);

    }
}