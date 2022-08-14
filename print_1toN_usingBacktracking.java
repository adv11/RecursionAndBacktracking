package RecursionAndBacktracking;

import java.util.Scanner;

public class print_1toN_usingBacktracking {
    public static void printNum(int n){
        if(n < 1)
            return;
        printNum(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        printNum(n);
    }
}
