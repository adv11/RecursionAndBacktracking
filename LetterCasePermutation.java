package RecursionAndBacktracking;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
LeetCode 784
* We have given a string, and we have to perform some operations and print permutations.
* Example:
* Input : a1B2
* Output : ["a1b2", "a1B2", "A1b2", "A1B2"]
*/

public class LetterCasePermutation {
    static Set<String> permutations = new HashSet<>();

    public static void letterCasePermutations(String output, String input) {
        // Base case
        if (input.equals("")) {
            permutations.add(output);
            return;
        }
        String outputLeft = output;
        String outputRight = output;

        // If the incoming character is number then simply append it to outputLeft and outputRight
        // else append lower case char into outputLeft and
        // upper case char into outputRight
        if (Character.isDigit(input.charAt(0))) {
            outputLeft += input.charAt(0);
            outputRight += input.charAt(0);
        } else if(Character.isLetter(input.charAt(0))){
            outputLeft += Character.toLowerCase(input.charAt(0));
            outputRight += Character.toUpperCase(input.charAt(0));
        }
        input = input.substring(1);

        letterCasePermutations(outputLeft, input);
        letterCasePermutations(outputRight, input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String input = sc.next();
        String output = "";
        letterCasePermutations(output, input);
        System.out.println(permutations);
    }
}
