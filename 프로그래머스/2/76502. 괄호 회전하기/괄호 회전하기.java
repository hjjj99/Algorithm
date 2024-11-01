import java.io.*;
import java.util.*;

class Solution {
    public static int answer;
    public int solution(String s) {
        answer = 0;
        
        int x = s.length();
        
        //회전
        for(int i=0; i<x; i++){
            String temp = "";
            temp = s.substring(i, x)+s.substring(0,i);
            check(temp);
        }
        
        return answer;
    }
    
    public static void check(String s){
        Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        
        
    }
}