package RecursionAndBacktracking;

import java.util.Scanner;

/*
* We have given a string, and we have to print the permutations of the given string in following format.
* Example :
* Input String : "ab"
* Output : "ab", "aB", "Ab", "AB"
*/
public class PermutationsWithCaseChange {
    public static void printPermutationsWithCaseChange(String output, String input){
        // Base case
        if(input.equals("")){
            System.out.println(output);
            return;
        }
        // creating 2 output strings for left and right child
        String outputLeft = output;
        String outputRight = output;

        // updating child strings
        outputLeft += input.charAt(0);  // appending the first char of the input string without changing the case
        outputRight += Character.toUpperCase(input.charAt(0));   // for changing the char into the upper case alphabet

        // removing the first char from the input string
        input = input.substring(1);

        // recursive calls
        printPermutationsWithCaseChange(outputLeft, input);
        printPermutationsWithCaseChange(outputRight, input);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter the input string:");
            String input = sc.next();
            String output = "";
            printPermutationsWithCaseChange(output, input);
        }
    }
}
