import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int C = Integer.parseInt(str.nextToken());

        //물건들의 무게를 저장할 list
        ArrayList<Integer> list = new ArrayList<>();
        str = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int w = Integer.parseInt(str.nextToken());
            list.add(w);
            
            //입력을 받으며 무게랑 같은 것이 있다면 물건 1개로 충족! 
            if(w==C){
                System.out.println(1);
                return;
            }
        }

        Collections.sort(list);
        int i=0;
        int j = N-1;
        int weight;

        
       
        //양쪽 index가 만날때까지 진행
        while(i<j){
            weight = list.get(i) + list.get(j);
            
            //index의 무게합이 C보다 크다면 j--
            if(weight > C){
                j--;
            
            //같다면 물건 2개로 C를 만드는 경우
            }else if(weight == C){ 		
                System.out.println(1);
                return;
                
            //C보다 작은 경우 아직 살펴보지않은 물건을 더해 3개로 C를 만들 수 있는지 확인
            //C에서 구해놓은 물건 2개의 합을 뺀 수가 리스트에 있는지만 확인
            }else{						
                if(list.indexOf(C-weight) < j && list.indexOf(C-weight) > i){
                    System.out.println(1);
                    return;
                }
                //C보다 작은데 남은 물건으로 안된다면 i++
                i++;
            }
        }
        //조건에 일치하는 경우가 없을 때 0을 출력
        

        System.out.println(0);
    }  
}