import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashSet <Integer> first = new HashSet<>();
        HashMap <Integer, Integer> second = new HashMap<>();
        
        first.add(topping[0]);
        for (int i = 1;i < topping.length; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=1; i<topping.length; i++){
            first.add(topping[i]);
            second.put(topping[i],second.get(topping[i])-1);
            if (second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }
            if (first.size() == second.size()) answer++;
        }
        return answer;
    }
}