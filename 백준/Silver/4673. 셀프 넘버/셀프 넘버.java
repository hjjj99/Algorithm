public class Main {
    public static int d(int num){
        int sum = num;
        while (num!=0){
            sum = sum + (num%10);
            num = num/10;
        }
        return sum;
    }
    
    public static void main(String[] args){
    	// 1~10000사이의 셀프넘버를 구해야한다.
        // 인덱스는 0부터 시작하기 때문에 배열크기를 10001으로 지정해야한다. (0~10000 인덱스 생성)
        boolean[] check = new boolean[10001];
        
        // 셀프 넘버가
        for(int i=1;i<=10000;i++){
            int n = d(i);
            if (n<10001){
                check[n] = true;
            }
        }
        // 셀프 넘버 출력
        for (int i = 1; i<=10000; i++){
            if (!check[i]){
                System.out.println(i);
            }
        }
    }
}