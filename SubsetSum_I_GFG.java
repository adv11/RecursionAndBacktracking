package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * GFG Link : https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
 * Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 6
 * arr[] = {3, 34, 4, 12, 5, 2}
 * sum = 9
 * Output: 1
 * Explanation: Here there exists a subset with
 * sum = 9, 4+3+2 = 9.
 * Example 2:
 *
 * Input:
 * N = 6
 * arr[] = {3, 34, 4, 12, 5, 2}
 * sum = 30
 * Output: 0
 * Explanation: There is no subset with sum 30.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function isSubsetSum() which takes the array arr[], its size N and an integer sum as input parameters and returns boolean value true if there exists a subset with given sum and false otherwise.
 * The driver code itself prints 1, if returned value is true and prints 0 if returned value is false.
 *
 *
 * Expected Time Complexity: O(sum*N)
 * Expected Auxiliary Space: O(sum*N)
 *
 *
 * Constraints:
 * 1 <= N <= 100
 * 1<= arr[i] <= 100
 * 1<= sum <= 105
 */
public class SubsetSum_I_GFG {
    public static void subsetSum(int index, int sum, int[] array, int sizeOfArray, ArrayList<Integer> ans){
        // Base case
        if(index == sizeOfArray){
            ans.add(sum);
            return;
        }

        // pick the element
        subsetSum(index+1, sum+array[index], array, sizeOfArray, ans);

        // not pick the element
        subsetSum(index+1, sum, array, sizeOfArray, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of testcases:");
        int numberOfTestcases = sc.nextInt();

        while (numberOfTestcases-- > 0){
            System.out.println("Enter the size of the array:");
            int sizeOfArray = sc.nextInt();

            System.out.println("Enter the elements of the array:");
            int[] array = new int[sizeOfArray];
            for(int index=0 ; index<sizeOfArray ; index++){
                array[index] = sc.nextInt();
            }

            ArrayList<Integer> ans = new ArrayList<>();
            subsetSum(0, 0, array, sizeOfArray, ans);
            Collections.sort(ans);
            System.out.println(ans);
        }
    }
}
