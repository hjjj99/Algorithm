import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
 
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        System.out.println("Gnomes:");
        for (int i = 0; i < testCase; i++) {
            int height1 = sc.nextInt();
            int height2 = sc.nextInt();
            int height3 = sc.nextInt();
            
            if ((height1 > height2 && height2 > height3) || (height1 < height2 && height2 < height3)) {
                System.out.println("Ordered");
            }
            else {
                System.out.println("Unordered");
            }
            
        }
    }
}