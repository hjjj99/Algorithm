class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0;
        int start = 0, end = 0;
        int len = -1;
        for (;  start < sequence.length; start++) {
            
            //아직 오른끝까지 안왔고 sum이 아직 덜 채워졌을때
			while(end < sequence.length && sum < k) {
				sum += sequence[end++];
			}
			
            //sum 다 됐을 때
			if (sum == k) {
				if (len == -1 || len > end - start) {
					answer[0] = start;
					answer[1] = end-1;
					len = end - start;
				}
			}
			
            //왼쪽지점 옮기기
			sum -= sequence[start];
		}
        
        return answer;
    }
}