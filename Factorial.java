package RecursionAndBacktracking;

import java.util.Scanner;

public class Factorial {

    // parameterized recursion
    public static void factorial_ParameterizedRecursion(int n, int fact){
        if(n == 1){
            System.out.println("Factorial of number is : " + fact);
            return;
        }
        factorial_ParameterizedRecursion(n-1, fact * n);
    }


    // functional recursion
    public static int factorial_FunctionalRecursion(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial_FunctionalRecursion(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N : ");
        int n = sc.nextInt();

        factorial_ParameterizedRecursion(n, 1);
        System.out.println("Factorial of " + n + " by Functional Recursion is : " + factorial_FunctionalRecursion(n));
    }
}
