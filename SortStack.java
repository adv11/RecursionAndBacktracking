package RecursionAndBacktracking;
import java.util.Scanner;
import java.util.Stack;
/*
* Given a stack we have to sort the stack into ascending order using recursion.
*/
public class SortStack {
    private static void sortStack(Stack<Integer> stack){
        if(stack.size() == 1)
            return;
        int temp = stack.pop();
        sortStack(stack);
        insertTemp(stack, temp);
    }
    // for Ascending order sorting
    public static void insertTemp(Stack<Integer> stack, int temp){
        if(stack.size() == 0 || stack.peek() <= temp){
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insertTemp(stack, temp);
        stack.push(val);
    }
    // for descending order sorting
//    public static void insertTemp(Stack<Integer> stack, int temp){
//        if(stack.size() == 0 || stack.peek() >= temp){
//            stack.push(temp);
//            return;
//        }
//        int val = stack.pop();
//        insertTemp(stack, temp);
//        stack.push(val);
//    }
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
            sortStack(stack);
            System.out.println(stack);
        }
    }
}
