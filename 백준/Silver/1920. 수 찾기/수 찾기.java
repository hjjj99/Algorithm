import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int mid;
    public static int find[], num[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(num);

        int M = Integer.parseInt(br.readLine());
        int find[] = new int[M];

        str = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            find[i] = Integer.parseInt(str.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            if(search(num, find[i]) >= 0){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);

    }
    
    public static int search(int[]a, int b){
        int l = 0;
        int r = a.length-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]==b){
                return mid;
            }
            else if(a[mid]>b){
                r = mid-1; 
            }
            else {
                l = mid+1;
            }
        }
        return -1;
    }
}