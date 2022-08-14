package RecursionAndBacktracking;

import java.util.Scanner;

public class Palindrome_string {

    // 2 pointer approach
    public static boolean palindromeCheck_twoPointer(String string, int left, int right){
        if(string.charAt(left) != string.charAt(right)){
            return false;
        }
        if(left < right){
            palindromeCheck_twoPointer(string, left+1, right-1);
        }
        return true;
    }


    // 1 pointer approach
    public static boolean palindromeCheck_onePointer(String string, int index){
        if(index >= string.length()/2){
            return true;
        }
        if(string.charAt(index) != string.charAt(string.length() - index - 1)){
            return false;
        }
        return palindromeCheck_onePointer(string, index+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t :");
        int t = sc.nextInt();

        while (t-- > 0){
            System.out.println("Enter the string:");
            String string = sc.next();

            System.out.println("By 2 pointer");
            boolean checkPalindrome = palindromeCheck_twoPointer(string, 0, string.length()-1);
            if(checkPalindrome)
                System.out.println(string + " is Palindrome.");
            else
                System.out.println(string + " is not Palindrome.");


            System.out.println("By 1 pointer");
            boolean checkPalindrome1 = palindromeCheck_onePointer(string, 0);
            if(checkPalindrome1)
                System.out.println(string + " is Palindrome.");
            else
                System.out.println(string + " is not Palindrome.");

            System.out.println();
        }
    }
}
