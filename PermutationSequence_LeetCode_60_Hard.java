package RecursionAndBacktracking;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * LeetCode Link : https://leetcode.com/problems/permutation-sequence/
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class PermutationSequence_LeetCode_60_Hard {
    // TC = O(N) * O(N) (for taking ele one by one for generating permutations * for deleting the elements from the arraylist)
    // Sc = O(N)
    public static String getPermutation(int n, int k) {
        int fact = 1;   // calculating the factorial of n-1

        // storing all numbers in ascending order
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=1 ; i<n ; i++){
            fact *= i;
            num.add(i);
        }
        num.add(n);

        // answer string
        String ans = "";

        // we are storing the numbers in 0 indexed arraylist so reduce the k by 1
        k = k - 1;

        while(true){
            ans += num.get(k / fact);   // append the number at index k/fact in arraylist
            num.remove(k / fact);   // remove that number from the arraylist

            // if there is no element in the arraylist then break the while loop
            if(num.size() == 0){
                break;
            }

            // reduce k by k%fact
            k %= fact;

            // divide fact by num arraylist's new size
            fact /= num.size();
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of testcases:");
        int numberOfTestcase = sc.nextInt();
        while (numberOfTestcase-- > 0){
            System.out.println("Enter the value of n:");
            int n = sc.nextInt();

            System.out.println("Enter the value of K:");
            int k = sc.nextInt();

            String requiredPermutation = getPermutation(n, k);
            System.out.println(requiredPermutation);
        }
    }
}
