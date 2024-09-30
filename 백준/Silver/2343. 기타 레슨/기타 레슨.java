import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] lesson;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        lesson = new int[N];

        str = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            lesson[i] = Integer.parseInt(str.nextToken());
            sum += lesson[i];
            max = Math.max(max, lesson[i]);
        }

        int L = max;
        int R = sum;
        int minSize = 0;

        while(L<=R){
            int mid = (L+R)/2;
            int count = 1;
            int length = 0;
            for(int i=0; i<N; i++){
                if(length + lesson[i] <= mid){
                    length += lesson[i];
                } else{
                    count ++;
                    length = lesson[i];
                }
            }

            if(count > M){
                L = mid + 1;
            } else{
                minSize = mid;
                R = mid-1;
            }
        }


        System.out.println(minSize);

    }

    
}