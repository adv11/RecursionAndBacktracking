package RecursionAndBacktracking;

import java.util.Scanner;

public class Print_Nto1_usingBacktracking {
    public static void printRevNum(int i, int n){
        if(i > n)
            return;
        printRevNum(i+1, n);
        System.out.print(i + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        printRevNum(1, n);
    }
}
