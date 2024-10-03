import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            map = new char[3][3];
            int countO = 0;
            int countX = 0;

            // 입력받은 문자열로 게임판 초기화
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = str.charAt(i * 3 + j);
                    if (map[i][j] == 'O') {
                        countO++;
                    } else if (map[i][j] == 'X') {
                        countX++;
                    }
                }
            }

            boolean xWins = check('X');
            boolean oWins = check('O');

            // 조건 1: X와 O의 개수가 유효한지 확인
            if (countX != countO + 1 && countX != countO) {
                System.out.println("invalid");
                continue;
            }

            // 조건 2: X와 O가 동시에 이기면 안 됨
            if (xWins && oWins) {
                System.out.println("invalid");
                continue;
            }

            // 조건 3: X가 이겼다면 X는 O보다 하나 더 많아야 함
            if (xWins && countX != countO + 1) {
                System.out.println("invalid");
                continue;
            }

            // 조건 4: O가 이겼다면 X와 O의 개수가 같아야 함
            if (oWins && countX != countO) {
                System.out.println("invalid");
                continue;
            }

            // 조건 5: 빈 칸이 없거나 승리한 경우만 valid
            if (!xWins && !oWins && countX + countO != 9) {
                System.out.println("invalid");
                continue;
            }

            // 모든 조건이 맞는 경우
            System.out.println("valid");
        }
    }

    // 승리 조건을 체크하는 함수
    public static boolean check(char player) {
        // 가로, 세로, 대각선 체크
        for (int i = 0; i < 3; i++) {
            // 가로 체크
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) {
                return true;
            }
            // 세로 체크
            if (map[0][i] == player && map[1][i] == player && map[2][i] == player) {
                return true;
            }
        }
        // 대각선 체크
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) {
            return true;
        }
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) {
            return true;
        }

        return false;
    }
}