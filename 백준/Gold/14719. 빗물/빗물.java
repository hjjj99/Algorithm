import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[] height = new int[W];	//블럭 높이 저장 배열
        int answer = 0;
        //블럭 높이 저장
        for(int i=0;i<W;i++)
            height[i] = Integer.parseInt(st.nextToken());

        //2번째 열부터 마지막 전 열까지 빗물 모이는 양 계산
        for(int i=1;i<W-1;i++){
            int left = 0, right = 0;	//좌측, 우측 최대 높이 블럭 변수
            //좌측 블럭 최대 높이 구하기
            for(int j=0;j<i;j++)
                left = Math.max(left, height[j]);
            //우측 블럭 최대 높이 구하기
            for(int j=i+1;j<W;j++)
                right = Math.max(right, height[j]);
            //현재 열 블럭이 좌측, 우측 블럭보다 작을 때
            if(height[i] < left && height[i] < right){
            	//고인 빗물 계산
                answer += Math.min(left, right) - height[i];
            }
        }
        bw.write(answer + "");	//고인 모든 빗물 양 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}