import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        //입력 sc.nextLine()
        int num = Integer.parseInt(sc.nextLine());  // int num = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < num; i++){
            String input = sc.nextLine();
            System.out.println(""+input.charAt(0) + input.charAt(input.length()-1)); //String.valueOf()
        }

    }
}