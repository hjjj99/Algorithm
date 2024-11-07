import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();        
        Map<String, String> map = new HashMap<>();
        
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            map.put(termSplit[0], termSplit[1]);
        }
        
        int num = 1;
        Integer todayTotalDate = getTotalDate(today, 0);
        
        for (String p : privacies) {
            String[] privateSplit = p.split(" ");
            String privateDate = privateSplit[0];
            String privateTerm = privateSplit[1];
            Integer termsMonth = Integer.valueOf(map.get(privateTerm));
            
            Integer privateTotalDate = getTotalDate(privateDate, termsMonth) - 1;
            
            if (privateTotalDate < todayTotalDate) {
                result.add(num);
            }
            
            num++;
        }
        
        return result.stream().mapToInt(n -> n).toArray();
    }
    
    public Integer getTotalDate(String strDate, Integer termsMonth) {
        String[] dateSplit = strDate.split("\\.");
        Integer year = Integer.valueOf(dateSplit[0]);
        Integer month = Integer.valueOf(dateSplit[1]) + termsMonth;
        Integer day = Integer.valueOf(dateSplit[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}