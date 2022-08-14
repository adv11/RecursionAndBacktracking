package RecursionAndBacktracking;
import java.util.Scanner;

/*
* We have given a string, and we have to find the permutations of the given string by putting( _ -> space) between the
* characters present in the given string.
*
* Example :
* String : ABC
* Output : [ABC, A_BC, AB_C, A_B_C] -> outer spaces are not allowed like : _ABC_
*/
public class PermutationWithSpaces {
    public static void printPermutations(String output, String input){
        // Base case : when the input becomes null then put output string into set and return
        if(input.equals("")){
            System.out.println(output);
            return;
        }
        // created 2 strings one for left child and other for right child
        String outputLeft = output;
        String outputRight = output;

        // Because we don't have choice for outer spaces means we don't have choice for input.charAt(0) character
        // so simply add it to outputLeft and outputRight and remove that character from the input string
        // Left child : we are not taking spaces
        // Right child : we are taking spaces
        outputLeft += input.charAt(0);
        outputRight += "_" + input.charAt(0);
        input = input.substring(1);


        // Recursive calls
        printPermutations(outputLeft, input);
        printPermutations(outputRight, input);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter the input string:");
            String input = sc.next();

            // Because we don't have choice for the first and last character of the input string so simply
            // remove first character from the input string and append that character to the output string
            // and send these output and input string to the recursive function
            String output = String.valueOf(input.charAt(0));
            input = input.substring(1);

            printPermutations(output, input);
        }
    }
}
