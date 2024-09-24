import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            st.push(str.charAt(i));

            if(st.size() >= bomb.length()){
                boolean contain = true;

                for(int j=0; j<bomb.length(); j++){
                    if(st.get(st.size() - bomb.length()+j) != bomb.charAt(j)){
                        contain = false;
                        break;
                    }
                }
                if(contain){
                    for(int j=0; j<bomb.length(); j++){
                        st.pop();
                        
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(st.isEmpty()) {
            sb.append("FRULA");
        } else {
            for(char c: st) {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}