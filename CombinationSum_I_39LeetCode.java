package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * Link : https://leetcode.com/problems/combination-sum/
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 */
public class CombinationSum_I_39LeetCode {
    public static void combinationSum(int[] array, int sizeOfArray, int targetSum, int index, List<List<Integer>> ansList,List<Integer> tempList){
        //Base case
        if(index == sizeOfArray){
            if(targetSum == 0){
                ansList.add(new ArrayList<>(tempList));
            }
            return;
        }

        // if selecting the element
        if(array[index] <= targetSum){
            tempList.add(array[index]);
            combinationSum(array, sizeOfArray, targetSum-array[index], index, ansList, tempList);
            tempList.remove(tempList.size()-1);
        }

        // not selecting the element
        combinationSum(array, sizeOfArray, targetSum, index+1, ansList, tempList);
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

            int index = 0;
            List<List<Integer>> ansList = new ArrayList<>();
            combinationSum(array, sizeOfArray, targetSum, index, ansList, new ArrayList<Integer>());
            System.out.println(ansList);
        }
    }
}
