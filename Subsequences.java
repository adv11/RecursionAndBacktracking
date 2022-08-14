package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Subsequences {
    public static void printSubsequences(int index, int[] array, int size, ArrayList<Integer> subsequences){
        if(index == size){
            for(int ele : subsequences){
                System.out.print(ele + " ");
            }

            if(subsequences.size() == 0){   // condition for null set
                System.out.println("Null set");
            }

            System.out.println();
            return;
        }

        subsequences.add(array[index]);
        printSubsequences(index+1, array, size, subsequences);      // pick
        subsequences.remove(subsequences.size()-1);
        printSubsequences(index+1, array, size, subsequences);      // not pick
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();

        while (t-- > 0){
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();

            int[] array = new int[size];
            System.out.println("Enter the elements of the array:");
            for(int i=0 ; i<size ; i++){
                array[i] = sc.nextInt();
            }

            ArrayList<Integer> subsequences = new ArrayList<>();
            printSubsequences(0, array, size, subsequences);
        }
    }
}
