import java.util.*;

class Solution {
    public static int sale[] = {10, 20, 30, 40};
    public static int set_sale[];
    public static int people, emo_cnt, maxPlus, maxFee;
    private static int[] emoticons, answer;
    private static int[][] users;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int answer[] = new int[2];
        this.users = users;
        this.emoticons = emoticons;
        people = users.length;
        emo_cnt = emoticons.length;
        set_sale = new int [emo_cnt];
        
        maxPlus = Integer.MIN_VALUE;
        maxFee = 0;
        setSale(set_sale, 0);
        
        answer[0] = maxPlus;
        answer[1] = maxFee;
        
        return answer;
    }
    
    public static void setSale(int[] set_sale, int idx){
        if(idx == emo_cnt){
            //할인율 다 골랐으면
            //얼마나 사는지 확인
            check(set_sale);
            return;
        }
        
        //선택
        for(int i=0; i<4; i++){
            set_sale[idx] = sale[i];
            setSale(set_sale, idx+1);
        }
    }
    
    public static void check (int[] rates){
        // System.out.println(Arrays.toString(rates));
        int fee = 0;
        int fee_total = 0;
        int plus_total = 0;
        
        for(int i=0; i<people; i++){
            fee = 0;
            for(int j=0; j<emo_cnt; j++){
                //살 조건 충족
                if(users[i][0] <= rates[j]){
                    fee += emoticons[j] * (100 - rates[j]) / 100;
                }    
            }
            if(fee >= users[i][1]){
                plus_total++;
                // fee_total += 5400;
            } else {
                fee_total += fee;
            }
        }
        
        if(plus_total > maxPlus){
            maxPlus = plus_total;
            maxFee = fee_total;
            System.out.println(Arrays.toString(rates));
        }
        else if(plus_total == maxPlus && fee_total>maxFee){
            maxPlus = plus_total;
            maxFee = fee_total;
            System.out.println(Arrays.toString(rates));
        }
    }
}