package RecursionAndBacktracking;
/*
* We have given a string, and we have to print the unique not repeated subsets of the given string.
* Example :
* String : "aab"
* Output : "", "a", "b", "aa", "ab", "aab"
*
*
* Hint : For this we simply store the result into Set in the base case.
*/
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrintUniqueSubsets {
    static Set<String> set = new HashSet<>();
    public static void printUniqueSubsets(String output, String input){
        // Base Case
        if(input.equals("")){
            if(output.equals("")){  // if the output string is empty then print " "
                set.add("\" \"");
            }else { // else print output string
                set.add("\"" + output + "\"");
            }
            return;
        }
        // divide the tree into two child left and right
        String outputLeft = output;
        String outputRight = output;

        // For left child : we take output string as it is before
        // For right child : we take output string by appending the 0th character of the input string
        outputRight += input.charAt(0);
        // Now update input string by deleting 0th character of the input string
        input = input.substring(1);
        // Now simply call the recursive function
        printUniqueSubsets(outputLeft, input);
        printUniqueSubsets(outputRight, input);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String input = sc.next();
        String output = "";
        printUniqueSubsets(output, input);
        System.out.println(set);
    }
}
