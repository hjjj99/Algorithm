import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static int N, count;
    public static ArrayList<String> results;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
       
        for(int T=1; T<=tc; T++){
            N = Integer.parseInt(br.readLine());
            results = new ArrayList<>();
            find("1", 1);
            Collections.sort(results);
            for (String result : results) {
                System.out.println(result);
            }
            System.out.println();
        }
    }

    public static void find(String expression, int idx) {
        if (idx == N) {
            if (cal(expression) == 0) {
                results.add(expression);
            }
            return;
        }

        int next = idx + 1;

        // 공백을 넣는 경우
        find(expression + " " + next, next);
        // '+'를 넣는 경우
        find(expression + "+" + next, next);
        // '-'를 넣는 경우
        find(expression + "-" + next, next);
    }

    public static int cal(String expression) {
        // 공백을 없애고 숫자와 연산자를 구분하여 계산
        expression = expression.replace(" ", "");
        int sum = 0;
        int currentNumber = 0;
        char currentSign = '+';

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == expression.length() - 1) {
                if (currentSign == '+') {
                    sum += currentNumber;
                } else if (currentSign == '-') {
                    sum -= currentNumber;
                }
                currentSign = c;
                currentNumber = 0;
            }
        }
        return sum;
    }
}