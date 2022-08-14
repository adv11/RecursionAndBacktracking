package RecursionAndBacktracking;

import java.util.Scanner;

public class Print_1_to_N {
    public static void print1toN(int n){
        // base condition
        if(n == 1)
            System.out.print("1 ");
        else{
            // hypothesis
            print1toN(n-1);
            // induction
            System.out.print(n + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
        print1toN(n);
    }
}
