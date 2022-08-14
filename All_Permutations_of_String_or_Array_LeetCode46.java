package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode link : https://leetcode.com/problems/permutations/
 *Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */

public class All_Permutations_of_String_or_Array_LeetCode46 {
    /**
     * TC = O(N!) * O(N) : O(N!) - for generating the permutations, O(N) - for storing the elements into the data structure
     * Sc = O(N) + O(N) : O(N) - for storing the permutations in to final list, O(N) - for freq array
     */
    public static void permutations_BruteForce(int[] array, int sizeOfArray, List<List<Integer>> ans, boolean[] freq, ArrayList<Integer> ds){
        // Base case
        if(ds.size() == sizeOfArray){
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Recursive call
        for(int index=0 ; index<sizeOfArray ; index++){
            if(!freq[index]){
                freq[index] = true;
                ds.add(array[index]);
                permutations_BruteForce(array, sizeOfArray, ans, freq, ds);
                ds.remove(ds.size()-1);
                freq[index] = false;
            }
        }
    }

    /**
     * TC = O(N!) * O(N)
     * SC = O(N) only considering recursion depth
     */
    public static void permutations_optimised(int index, int[] array, int sizeOfArray,  List<List<Integer>> ans){
        // Base case
        if(index == sizeOfArray){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0 ; i<sizeOfArray ; i++){
                ds.add(array[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Recursive call
        for(int i=index ; i<sizeOfArray ; i++){
            swapElements(array, index, i);
            permutations_optimised(index+1, array, sizeOfArray, ans);
            swapElements(array, index, i);
        }
    }
    public static void swapElements(int[] array, int index1, int index2){
        int tempElement = array[index1];
        array[index1] = array[index2];
        array[index2] = tempElement;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
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
//            boolean[] freq = new boolean[sizeOfArray];
//            permutations_BruteForce(array, sizeOfArray, ans, freq, new ArrayList<Integer>());

            permutations_optimised(0, array, sizeOfArray, ans);
            System.out.println(ans);
        }
    }
}
