package RecursionAndBacktracking;
/*
* We have given a stack containing numbers we have to delete the middle element present in the stack.
* Middle element is present at position : (stack.size() / 2 + 1)
*/
import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElementFromStack {
    private static void deleteMiddle(Stack<Integer> stack, int k){
        // Base condition
        if(stack.size() == 0)
            return;
        solve(stack, k);
    }
    public static void solve(Stack<Integer> stack, int k){
        // Base condition : if k==1 it means that the top element is the deleting element which we have to delete
        if(k == 1){
            stack.pop();
            return;
        }
        // else
        int val = stack.pop();
        solve(stack, k-1);
        stack.push(val);
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
            int k = stack.size()/2 + 1;
            deleteMiddle(stack, k);
            System.out.println(stack);
        }
    }
}
