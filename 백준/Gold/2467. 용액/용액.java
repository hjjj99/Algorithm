import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] solutions = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n-1;
        int answer = Integer.MAX_VALUE;
        int solution1=0, solution2=0;
        while(left < right){
            int sum = solutions[left] + solutions[right];
            if(Math.abs(sum) < Math.abs(answer)){
                answer = sum;
                solution1 = solutions[left];
                solution2 = solutions[right];
            }
            if(sum == 0){
                break;
            } else if(sum < 0){
                left++;
            } else {
                right--;
            }
        }
        System.out.println(solution1 + " " + solution2);
    }
}