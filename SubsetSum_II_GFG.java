package RecursionAndBacktracking;

import java.util.*;
/**
 * LeetCode link : https://leetcode.com/problems/subsets-ii/
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetSum_II_GFG {
    public static void subsets(int index, int[] array, int sizeOfArray, List<List<Integer>> ans, ArrayList<Integer> ds){
        // adding null list
        ans.add(new ArrayList<>(ds));

        // running loop from index to size-1
        // for adding other valid subsets
        for(int i=index ; i<sizeOfArray ; i++){
            // condition for duplicate element
            if(i>index && array[i]==array[i-1]){
                continue;
            }

            // performing recursive call
            ds.add(array[i]);
            subsets(i+1, array, sizeOfArray, ans, ds);
            ds.remove(ds.size()-1);
        }
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

            List<List<Integer>> ans = new ArrayList<>();
            subsets(0, array, sizeOfArray, ans, new ArrayList<>());
            Arrays.sort(array);
            System.out.println(ans);
        }
    }
}
