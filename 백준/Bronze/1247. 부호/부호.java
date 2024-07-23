import java.math.BigInteger;
import java.util.Scanner;

/**
 * 부호
 * https://www.acmicpc.net/problem/1247
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            BigInteger answer = new BigInteger("0");
            while (n-- > 0) {
                answer = answer.add(sc.nextBigInteger());
            }

            if (answer.compareTo(BigInteger.ZERO) == -1) {
                System.out.println("-");
            } else if (answer.compareTo(BigInteger.ZERO) == 1) {
                System.out.println("+");
            } else {
                System.out.println(0);
            }
        }
    }
}