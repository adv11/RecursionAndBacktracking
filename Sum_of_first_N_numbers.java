package RecursionAndBacktracking;

import java.util.Scanner;

public class Sum_of_first_N_numbers {

    // Parameterized Recursive function : When we don't want to return from the function
    public static void sumOfNumbers_ParameterizedRecursion(int n, int sum){
        if(n < 1){
            System.out.println("Sum of first n numbers by Parameterized recursion is : " + sum);
            return;
        }
        sumOfNumbers_ParameterizedRecursion(n-1, sum+n);
    }

    // Functional Recursive Function : When we want to return the value from the function
    public static int sumOfNumbers_FunctionalRecursion(int n){
        if(n == 0)
            return 0;
        return n + sumOfNumbers_FunctionalRecursion(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        sumOfNumbers_ParameterizedRecursion(n,0);
        System.out.println("Sum of first n numbers by functional recursion is : " + sumOfNumbers_FunctionalRecursion(n));
    }
}
