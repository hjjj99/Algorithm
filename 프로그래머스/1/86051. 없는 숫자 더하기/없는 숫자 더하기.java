class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] ten = new boolean[10];
        
        for(int i=0; i<numbers.length; i++){
            ten[numbers[i]] = true;
        }
        
        for(int i=1; i<=9; i++){
            if(!ten[i]){
                answer += i;
            }
        }
        
        return answer;
    }
}