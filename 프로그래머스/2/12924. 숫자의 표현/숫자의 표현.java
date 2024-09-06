class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int sum = 0;
        
        for(int i=1; i<=n/2; i++){
            sum = 0;
            for(int j=0; j<n-i; j++){
                sum += i + j;
                if(sum == n){
                    answer++;
                }
                if(sum > n){
                    break;
                }
            }
        }
        return answer;
    }
}