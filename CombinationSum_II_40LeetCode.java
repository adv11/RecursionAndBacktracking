package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode link : https://leetcode.com/problems/combination-sum-ii/
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSum_II_40LeetCode {
    public static void combinationSum(int[] array, int targetSum, int index, List<List<Integer>> ansList, List<Integer> tempList){
        // Base case
        if(targetSum == 0){
            ansList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=index ; i<array.length ; i++){
            // duplicate element case, so don't call recursion here
            if(i>index && array[i]==array[i-1]){
                continue;
            }

            // recursion breaking case when we have target < array[i]
            if(array[i] > targetSum){
                break;
            }

            // recursion calling case
            tempList.add(array[i]);
            combinationSum(array, targetSum-array[i], i+1, ansList, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcases:");
        int noOfTestcases = sc.nextInt();

        while (noOfTestcases-- > 0){
            System.out.println("Enter the size of the array:");
            int sizeOfArray = sc.nextInt();

            System.out.println("Enter the elements of the array:");
            int[] array = new int[sizeOfArray];
            for(int index=0 ; index<sizeOfArray ; index++){
                array[index] = sc.nextInt();
            }

            System.out.println("Enter the target sum:");
            int targetSum = sc.nextInt();

            List<List<Integer>> ansList = new ArrayList<>();
            Arrays.sort(array);
            combinationSum(array, targetSum, 0, ansList, new ArrayList<>());
            System.out.println(ansList);
        }
    }
}
