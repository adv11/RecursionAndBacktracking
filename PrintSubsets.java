package RecursionAndBacktracking;
/* We have given a string, and we have to print all the substrings of the given string(Power set : set of all subsets)
Example:
Input : ab
Output : {" ", "a", "b", "ab"}
*/
import java.util.Scanner;

public class PrintSubsets {
    public static void printSubsets(String output, String input){
        // Base Case
        if(input.equals("")){
            if(output.equals("")){  // if the output string is empty then print " "
                System.out.println("\" \"");
            }else { // else print output string
                System.out.println("\"" + output + "\"");
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
        printSubsets(outputLeft, input);
        printSubsets(outputRight, input);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testCases:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the input string:");
            String input = sc.next();
            String output = "";
            printSubsets(output, input);
        }
    }
}
