import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        // 방향에 따른 좌표 변화 (L, R, U, D)
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        
        Set<String> visitedPaths = new HashSet<>();
        
        int x = 0, y = 0;  // 시작 좌표 (0, 0)
        
        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;
            
            // 방향에 따른 좌표 업데이트
            if (dir == 'L') {
                nx = x + dx[0];
                ny = y + dy[0];
            } else if (dir == 'R') {
                nx = x + dx[1];
                ny = y + dy[1];
            } else if (dir == 'U') {
                nx = x + dx[3];
                ny = y + dy[3];
            } else if (dir == 'D') {
                nx = x + dx[2];
                ny = y + dy[2];
            }
            
            // 경계를 벗어나는 경우는 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            // 새로운 길이면 경로 저장
            String path1 = x + "," + y + "->" + nx + "," + ny;  // (x, y)에서 (nx, ny)로 가는 경로
            String path2 = nx + "," + ny + "->" + x + "," + y;  // (nx, ny)에서 (x, y)로 가는 경로 (반대 방향)
            
            if (!visitedPaths.contains(path1) && !visitedPaths.contains(path2)) {
                visitedPaths.add(path1);
                visitedPaths.add(path2);
            }
            
            // 현재 좌표 업데이트
            x = nx;
            y = ny;
        }
        
        // 방문한 새로운 길의 개수 리턴
        return visitedPaths.size() / 2;
    }
}
