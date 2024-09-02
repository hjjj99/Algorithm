import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int[] count = new int[10000001];
        
        int n = tangerine.length;
        for(int i=0; i<n; i++){
            count[tangerine[i]]++;
        }
        
        // 카운트 배열에서 0이 아닌 값들만 리스트에 담기
        List<Integer> countList = new ArrayList<>();
        for (int c : count) {
            if (c > 0) {
                countList.add(c);
            }
        }
        
        // 내림차순으로 정렬
        Collections.sort(countList, Collections.reverseOrder());

        
        int sum = 0;
        int idx = 0;
        while(sum<k){
            sum += countList.get(idx);
            answer ++;
            idx++;
        }
        return answer;
    }
}