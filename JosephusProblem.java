package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {
    public static void solveJosephus(ArrayList<Integer> persons, int k, int swordIndex){
        // Base case
        if(persons.size() == 1){
            System.out.println(persons.get(0));
            return;
        }
        // performing modulo operation because we have access the element in a circular way in the array
        // that's why we are using modulo operator for neglecting indexOutOfBound error
        swordIndex = (swordIndex + k) % persons.size();
        persons.remove(swordIndex); // removing the person which was killed from the persons array
        solveJosephus(persons, k, swordIndex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter N:");
            int n = sc.nextInt();
            System.out.println("Enter K:");
            int k = sc.nextInt();

            // storing the numbers of the person
            ArrayList<Integer> persons = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                persons.add(i + 1);
            }
            // calling function
            // pass k-1 because index starts from 0
            solveJosephus(persons, k-1, 0);
        }
    }
}
