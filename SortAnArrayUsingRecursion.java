package RecursionAndBacktracking;
/*
* We have given an array of integers ans we have to sort the array but by using Recursion only.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class SortAnArrayUsingRecursion {
    // Method for sorting the array
    public static void sortArray(ArrayList<Integer> arrayList){
        // Base condition
        if(arrayList.size() == 1){
            return;
        }
        int temp = arrayList.get(arrayList.size()-1);   // storing last element
        arrayList.remove(arrayList.size()-1);   // remove last element from the arraylist
        sortArray(arrayList);   // now call sortArray(arrayList> -> now size is n-1(previous size - 1)
        insertTemp(arrayList, temp);    // call met hod for storing last element into it's appropriate position
    }
    // method for storing last element into it's proper position
    // for ascending order sorting
    public static void insertTemp(ArrayList<Integer> arrayList, int temp){
        // Base Condition
        if(arrayList.size()==0 || arrayList.get(arrayList.size()-1)<=temp){
            arrayList.add(temp);
            return;
        }
        // if the last element is not smaller than temp
        // then store last value into some variable names val and remove that element from the arrayList
        // now call insertTemp and at last add val
        int val = arrayList.get(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
        insertTemp(arrayList, temp);
        arrayList.add(val);
    }
    // for descending order sorting
//    public static void insertTemp(ArrayList<Integer> arrayList, int temp){
//        // Base Condition
//        if(arrayList.size()==0 || arrayList.get(arrayList.size()-1)>=temp){
//            arrayList.add(temp);
//            return;
//        }
//        // if the last element is not smaller than temp
//        // then store last value into some variable names val and remove that element from the arrayList
//        // now call insertTemp and at last add val
//        int val = arrayList.get(arrayList.size()-1);
//        arrayList.remove(arrayList.size()-1);
//        insertTemp(arrayList, temp);
//        arrayList.add(val);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter elements: if want to stop enter -1");
            ArrayList<Integer> arrayList = new ArrayList<>();
            int ele = 0;
            ele = sc.nextInt();
            while (ele != -1){
                arrayList.add(ele);
                ele = sc.nextInt();
            }
            sortArray(arrayList);
            System.out.println(arrayList);
        }
    }
}
