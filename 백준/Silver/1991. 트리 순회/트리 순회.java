import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        

        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            char c = str.nextToken().charAt(0);
            char left = str.nextToken().charAt(0);
            char right = str.nextToken().charAt(0);
            
            insertNode(head, c, left, right);
        } //트리 입력 끝

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

    }

    public static class Node{
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node tmp, char root, char left, char right) {
        if (tmp.value == root) {
            tmp.left = (left == '.' ? null : new Node(left, null, null));
            tmp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (tmp.left != null) {
                insertNode(tmp.left, root, left, right);
            }
            if (tmp.right != null) {
                insertNode(tmp.right, root, left, right);
            }
        }
    }

    private static void preOrder(Node node) {
        if (node == null) { // 더 이상 값이 없을 때 까지
            return;
        }
        System.out.print(node.value); // 출력
        preOrder(node.left); // 왼쪽 노드 탐색
        preOrder(node.right); // 오른쪽 노드 탐색
    }

    private static void inOrder(Node node) {
        if (node == null) { // 더 이상 값이 없을 때 까지
            return;
        }
        inOrder(node.left); // 왼쪽 노드 탐색
        System.out.print(node.value); // 출력
        inOrder(node.right); // 오른쪽 노드 탐색
    }

    private static void postOrder(Node node) {
        if (node == null) { // 더 이상 값이 없을 때 까지
            return;
        }
        postOrder(node.left); // 왼쪽 노드 탐색
        postOrder(node.right); // 오른쪽 노드 탐색
        System.out.print(node.value); // 출력
    }
}