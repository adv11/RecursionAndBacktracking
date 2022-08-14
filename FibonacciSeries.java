package RecursionAndBacktracking;

import java.util.Scanner;

public class FibonacciSeries {
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the value of N:");
            int n = sc.nextInt();

            System.out.println(n + "th elements in Fibonacci series is : " + fibonacci(n));
        }
    }
}
