import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'c' && i < input.length() - 1) {
                if (input.charAt(i + 1) == '=' || input.charAt(i + 1) == '-')
                    i++;
            } else if (input.charAt(i) == 'd' && i < input.length() - 1) {
                if (input.charAt(i + 1) == '-')
                    i++;
                else if (input.charAt(i + 1) == 'z' && i < input.length() - 2) {
                    if (input.charAt(i + 2) == '=')
                        i += 2;
                }
            } else if ((input.charAt(i) == 'l' || input.charAt(i) == 'n') && i < input.length() - 1) {
                if (input.charAt(i + 1) == 'j')
                    i++;
            } else if ((input.charAt(i) == 's' || input.charAt(i) == 'z') && i < input.length() - 1) {
                if (input.charAt(i + 1) == '=')
                    i++;
            }
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}