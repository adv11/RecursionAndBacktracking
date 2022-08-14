package RecursionAndBacktracking;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an array and sum K. We have to print all the subsequences with sum equal to K.
 * Example :
 * A = [1, 2, 1], K = 2
 * [1, 1] and [2]
 */
public class Subsequences_with_sum_equal_to_K {
    public static void printSubsequences(int index, int[] array, ArrayList<Integer> subsequence, int initialSum, int targetSum, int size){

        // Base case : when index is equal to size then check for equality of sum if it follows then print it.
        if(index == size){
            if(initialSum == targetSum){
                for(int ele : subsequence){
                    System.out.print(ele + " ");
                }
                System.out.println();
            }
            return;
        }

        // Case 1 : pick the element
        subsequence.add(array[index]);  // adding ele to the list
        initialSum += array[index];     // add that ele into the initialSum variable
        printSubsequences(index+1, array, subsequence, initialSum, targetSum, size);
        initialSum -= array[index];
        subsequence.remove(subsequence.size()-1);

        // Case 2 : Not picking the element
        printSubsequences(index+1, array, subsequence, initialSum, targetSum, size);
    }



    /**
     * Trick to print only one result while using Recursion.
     *
     * f(){
     *     Base Case
     *     if(condition satisfied){
     *         return true;
     *     }else{
     *         return false;
     *     }
     * }
     *
     * Now, write this type of code while calling this recursive function from any class.
     * public static void main(String[] args){
     *     Scanner sc = new Scanner(System.in);
     *     if(f() == true){
     *         return true;
     *     }
     *     f();
     *     return false;
     * }
     */
    /**
     * Given an array and sum K. We have to print all the subsequences with sum equal to K.
     * Example :
     * A = [1, 2, 1], K = 2
     * [1, 1]
     */
    public static boolean printOnlyOneSubsequence(int index, int[] array, ArrayList<Integer> subsequence, int initialSum, int totalSum, int size){
        // Base case : when index is equal to size then check for equality of sum if it follows then print it.
        if(index == size){
            if(initialSum == totalSum){
                for(int ele : subsequence){
                    System.out.print(ele + " ");
                }
                System.out.println();
                return true;
            }
            return false;
        }

        // Case 1 : pick the element
        subsequence.add(array[index]);  // adding ele to the list
        initialSum += array[index];     // add that ele into the initialSum variable
        if(printOnlyOneSubsequence(index+1, array, subsequence, initialSum, totalSum, size) == true){
            return true;
        }
        initialSum -= array[index];
        subsequence.remove(subsequence.size()-1);

        // Case 2 : Not picking the element
        if(printOnlyOneSubsequence(index+1, array, subsequence, initialSum, totalSum, size) == true){
            return true;
        }
        return false;
    }


    /**
     * Count of Subsequences with the sum equal to K in the given array.
     * Input : A = {1, 2, 1}, K = 2
     * Output : 2
     *
     * Trick :
     * f(){
     *     Base case
     *     return 1 - if condition satisfies
     *     return 0 - if condition does not satisfy
     *     left = f()
     *     right = f()
     *     return left+right
     * }
     */
    /**
     * Given an array and sum K. We have to print all the subsequences with sum equal to K.
     * Example :
     * A = [1, 2, 1], K = 2
     * Output : 2
     */
    public static int countSubsequences(int index, int[] array, ArrayList<Integer> subsequence, int initialSum, int totalSum, int size){
        // Base case : when index is equal to size then check for equality of sum if it follows then print it.
        if(index == size){
            if(initialSum == totalSum){
                return 1;
            }
            return 0;
        }

        // Case 1 : pick the element
        subsequence.add(array[index]);  // adding ele to the list
        initialSum += array[index];     // add that ele into the initialSum variable
        int left = countSubsequences(index+1, array, subsequence, initialSum, totalSum, size);
        initialSum -= array[index];
        subsequence.remove(subsequence.size()-1);

        // Case 2 : Not picking the element
        int right = countSubsequences(index+1, array, subsequence, initialSum, totalSum, size);

        return left + right;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the size of the array :");
            int size = sc.nextInt();

            System.out.println("Enter the elements:");
            int[] array = new int[size];
            for(int i=0 ; i<size ; i++){
                array[i] = sc.nextInt();
            }

            System.out.println("Enter the value of K :");
            int k = sc.nextInt();

            ArrayList<Integer> subsequence = new ArrayList<>();

            // Ques 1 : Print subsequences with sum equal to K
            System.out.println("subsequences with sum equal to K");
            printSubsequences(0, array, subsequence, 0, k, size);


            // Ques 2 : Print only one subsequence with sum equal to K
            System.out.println("\nPrinting only one subsequence by recursion : ");
            printOnlyOneSubsequence(0, array, subsequence, 0, k, size);


            // Ques 3 : Count number of subsequences with the sum equal to K
            System.out.println("\nNumber of subsequences with sum " + k + " is : ");
            int count = countSubsequences(0, array, subsequence, 0, k, size);
            System.out.println(count);

            System.out.println();
        }
    }
}
