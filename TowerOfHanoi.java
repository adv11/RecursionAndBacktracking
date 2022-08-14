package RecursionAndBacktracking;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void towerOfHanoi(int numberOfPlates, int towerId1, int towerId2, int towerId3){
        // Base case
        if(numberOfPlates == 0) {
            return;
        }
        towerOfHanoi(numberOfPlates-1, towerId1, towerId3, towerId2);   // swap last two towers : tower2 and tower3
        System.out.println(numberOfPlates + "[" + towerId1 + " -> " + towerId2 + "]");  // transfer plates from tower1 to tower2
        towerOfHanoi(numberOfPlates-1, towerId3, towerId2, towerId1);   // swap first and last towers : tower1 and tower3
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter number of plates:");
            int numberOfPlates = sc.nextInt();
            System.out.println("Enter tower 1:");
            int tower1 = sc.nextInt();
            System.out.println("Enter tower 2:");
            int tower2 = sc.nextInt();
            System.out.println("Enter tower 3:");
            int tower3 = sc.nextInt();

            System.out.println("Steps fo Tower of Hanoi are:");
            towerOfHanoi(numberOfPlates, tower1, tower2, tower3);
        }
    }
}
