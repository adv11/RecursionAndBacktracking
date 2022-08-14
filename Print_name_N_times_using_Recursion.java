package RecursionAndBacktracking;

import java.util.Scanner;

public class Print_name_N_times_using_Recursion {
    public static void printName(int i, int n){
        if(i > n){      // Base Case
            return;
        }
        System.out.println("Akash Deep Vishwakarma");
        printName(i+1, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N:");
        int n = sc.nextInt();

        printName(1, n);
    }
}
