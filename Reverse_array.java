package RecursionAndBacktracking;

import java.util.Scanner;

public class Reverse_array {

    // By two reference approach
    public static int[] reverseArray(int[] a, int left, int right){
        if(left >= right){
            return a;
        }else {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        return reverseArray(a, left+1, right-1);
    }

    // By one reference approach
    public static int[] reverseArray_oneReference(int[] a, int index, int size){
        if(index >= size/2){
            return a;
        }
        if(index < (size - index - 1)){
            int temp = a[index];
            a[index] = a[size - index - 1];
            a[size - index - 1] = temp;
        }
        return reverseArray_oneReference(a, index+1, size);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter the length of the array : ");
            int size = sc.nextInt();

            int[] a1 = new int[size];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++) {
                a1[i] = sc.nextInt();
            }

            int[] a2 = a1.clone();

            System.out.println("By two reference approach");
            int[] b = reverseArray(a1, 0, size - 1);
            for (int ele : b) {
                System.out.print(ele + " ");
            }
            System.out.println();


            System.out.println("By one reference approach");
            int[] c = reverseArray_oneReference(a2, 0, size);
            for(int ele : c){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
