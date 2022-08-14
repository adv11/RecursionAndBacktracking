package RecursionAndBacktracking;

import java.util.Scanner;

/*
Given a positive integer N, the task is to find all the N bit binary numbers having more than or equal 1's
than 0's for any prefix of the number.

Example:
Input : N = 2
Output : 11, 10

Input : N = 3
Output : 111, 110, 101
*/
public class Print_N_bitBinaryNumbersHavingMore_1s_than_0s {
    public static void solve(String output, int ones, int zeroes, int n){
        // Base case
        if(n == 0){
            System.out.println(output);
            return;
        }
        // condition for adding one
        // Always getting this case
        // we can always add 1 there is no particular condition for adding 1
        solve(output + "1", ones+1, zeroes, n-1);

        // condition for adding zero
        // Rarely getting this case
        // when number of ones > number of zeroes then we can add zero otherwise not
        if(ones > zeroes){
            solve(output + "0", ones, zeroes+1, n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the value of N:");
            int n = sc.nextInt();

            int ones = 0, zeroes = 0;
            String output = "";
            solve(output, ones, zeroes, n);
        }
    }
}
