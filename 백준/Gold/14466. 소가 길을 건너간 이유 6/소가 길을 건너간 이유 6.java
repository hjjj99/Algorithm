import java.util.*;
import java.io.*;

public class Main {
	//농장 위치 관련 클래스
    static class position{
        int x, y;
        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N,K,R;
    static ArrayList<position>[][] road;	//길 저장 배열
    static position[] cow;	//소 위치 저장 배열
    static int[] dx = {0, 0, -1, 1};	//상하좌우 x값 변경값
    static int[] dy = {-1, 1, 0, 0};	//상하좌우 y값 변경값
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        road = new ArrayList[N+1][N+1];
        cow = new position[K];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++)
                road[i][j] = new ArrayList<>();
        }
        //길에 대한 정보 저장
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine()," ");
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            road[r1][c1].add(new position(c2,r2));
            road[r2][c2].add(new position(c1,r1));
        }
        //소에 대한 정보 저장
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            cow[i] = new position(c1,r1);
        }

        int count = 0;
        //BFS탐색으로 길을 건너지 않고 만나는 소의 쌍인지 확인
        for(int i=0;i<K;i++){
            for(int j=i+1;j<K;j++){
                if(bfs(cow[i], cow[j]))	//길을 건너지 않고 만날 때
                    count++;
            }
        }
        bw.write(count +"");	//길을 건너지 않고 만나는 쌍의 개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //길을 건너지 않고 만나는 소의 쌍을 구하는 BFS 함수
    static boolean bfs(position startCow, position endCow){
        Queue<position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        visited[startCow.y][startCow.x] = true;
        queue.add(startCow);
        while(!queue.isEmpty()){
            position cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            if(x==endCow.x && y == endCow.y)	//소끼리 만났을 때
                return false;
            for(int i=0;i<4;i++){
                int tempX = x + dx[i];
                int tempY = y + dy[i];
                if(tempX>0 && tempY>0 && tempX<=N && tempY<=N && !visited[tempY][tempX]){
                    boolean check = true;
                    for(int j=0;j<road[y][x].size();j++){	//길을 건널 때
                        if(road[y][x].get(j).x == tempX && road[y][x].get(j).y == tempY){
                            check = false;
                            break;
                        }
                    }
                    if(check){	//길이 아닐 때
                        visited[tempY][tempX] = true;
                        queue.add(new position(tempX,tempY));
                    }
                }
            }
        }
        return true;
    }
}