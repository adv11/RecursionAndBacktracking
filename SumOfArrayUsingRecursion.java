package RecursionAndBacktracking;

import java.util.Scanner;

public class SumOfArrayUsingRecursion {
    public static int sumOfArray(int[] a, int size){
        int sum = 0;
        if(size <= 0){
            return 0;
        }
        sum += sumOfArray(a, size-1) + a[size-1];
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();

            System.out.println("Enter the elements of the array:");
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }

            System.out.println(sumOfArray(array, size));
        }
    }
}
