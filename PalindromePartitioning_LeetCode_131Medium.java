package RecursionAndBacktracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode link : https://leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromePartitioning_LeetCode_131Medium {
    public static List<List<String>> palindromePartitioning(String s){
        List<List<String>> ans = new ArrayList<>();
        int index = 0;
        solve(s, index, ans, new ArrayList<>());
        return ans;
    }
    public static void solve(String string, int index, List<List<String>> ans, ArrayList<String> ds){
        // Base case
        if(index == string.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }


        // Running loop from index to string.length()
        for(int i=index ; i<string.length() ; i++){

            // checking is the substring is palindrome or not
            if(isPalindrome(string, index, i)){

                // if the substring is palindrome then add otherwise not
                ds.add(string.substring(index, i+1));
                // recursion call for next index
                solve(string, i+1, ans, ds);
                // backtracking step
                ds.remove(ds.size()-1);
            }
        }
    }

    // method for checking if the substring is palindrome or not
    public static boolean isPalindrome(String string, int start, int end){
        while (start <= end){
            if(string.charAt(start++) != string.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of testcases:");
        int numberOfTestcases = sc.nextInt();

        while (numberOfTestcases-- > 0){
            System.out.println("Enter the string :");
            String string = sc.next();

            List<List<String>> answerList = palindromePartitioning(string);
            System.out.println(answerList);
        }
    }
}
