package RecursionAndBacktracking;
import java.util.Scanner;

/*
LeetCode 22
* We have given a value of n, and we have to generate the balanced parentheses containing n pairs of small brackets.
* Example :
* 1) n = 1, output = "()"
* 2) n = 2, output = "()()", "(())"
* 3) n = 3, output = "((()))", "()()()", "(())()", "()(())", "(()())"
*/
public class GenerateAllBalancedParentheses {
    public static void generateBalancedParentheses(String output, int openingBracketCount, int closingBracketCount) {
        // Base case
        if(openingBracketCount==0 && closingBracketCount==0){
            System.out.println(output);
            return;
        }
        // condition for opening bracket
        // This condition is always happening
        if(openingBracketCount != 0){
            String newOutput = output;
            newOutput += "(";
            generateBalancedParentheses(newOutput, openingBracketCount-1, closingBracketCount);
        }
        // condition for both opening and closing brackets
        // This condition is happening sometimes
        if(closingBracketCount > openingBracketCount){
            String newOutput = output;
            newOutput += ")";
            generateBalancedParentheses(newOutput, openingBracketCount, closingBracketCount-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            System.out.println("Enter the value of n:");
            int n = sc.nextInt();

            int openingBracketCount = n, closingBracketCount = n;
            String output = "";
            generateBalancedParentheses(output, openingBracketCount, closingBracketCount);
        }
    }
}
