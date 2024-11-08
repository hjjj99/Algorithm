import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 보석의 종류 개수를 파악
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();
        
        // 결과 변수 초기화
        int[] answer = new int[] {0, gems.length - 1};
        Map<String, Integer> gemCount = new HashMap<>();
        
        int left = 0;
        int right = 0;
        
        // 슬라이딩 윈도우를 사용하여 가장 짧은 구간을 찾음
        while (right < gems.length) {
            // 현재 보석 추가
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            right++;
            
            // 모든 종류의 보석을 포함할 경우
            while (gemCount.size() == totalTypes) {
                // 현재 구간이 더 짧은지 확인하고 갱신
                if (right - left < answer[1] - answer[0] + 1) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                
                // 왼쪽 보석을 하나 제거하고 윈도우 축소
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]);
                }
                left++;
            }
        }
        
        // 1번 진열대부터 시작하도록 배열 조정
        answer[0]++;
        answer[1]++;
        
        return answer;
    }
}
