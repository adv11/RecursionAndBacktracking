package RecursionAndBacktracking;
/*
* Reverse stack using recursion without using extra space.
*/
import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    private static void reverseStack(Stack<Integer> stack){
        // Base Condition
        if(stack.size() == 1)
            return;
        int val = stack.pop();
        reverseStack(stack);
        pushValAtEnd(stack, val);
    }
    public static void pushValAtEnd(Stack<Integer> stack, int val){
        // Base condition
        if(stack.size() == 0){
            stack.push(val);
            return;
        }
        int temp = stack.pop();
        pushValAtEnd(stack, val);
        stack.push(temp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter elements: if want to stop enter -1");
            Stack<Integer> stack = new Stack<>();
            int ele = 0;
            ele = sc.nextInt();
            while (ele != -1){
                stack.push(ele);
                ele = sc.nextInt();
            }
            reverseStack(stack);
            System.out.println(stack);
        }
    }
}
