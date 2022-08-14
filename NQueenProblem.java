package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode link (59 Hard) : https://leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
 * a queen and an empty space, respectively.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
public class NQueenProblem {

    // Approach 1 : Brute force - taking space TC for searching valid place to place the queen
    // This canPlace() method takes extra space as it is taking O(N) for searching on left side upward diagonal
    // O(N) time for searching on left side row and similarly O(N) time for searching on left side
    // downward diagonal.
    // So, we have to reduce this time complexity by using Hashing.
//    public static boolean canPlace_bruteForce(int row, int column, char[][] board, int n){
//        int duplicateRow = row, duplicateColumn = column;
//
//        // checking left side upward diagonal
//        while(row>=0 && column>=0){
//            if(board[row][column] == 'Q'){
//                return false;
//            }
//            row--;
//            column--;
//        }
//
//        row = duplicateRow;
//        column = duplicateColumn;
//
//        // checking the left side straight row
//        while(column>=0){
//            if(board[row][column] == 'Q'){
//                return false;
//            }
//            column--;
//        }
//
//        column = duplicateColumn;
//
//        // checking left side downward diagonal
//        while(row<n && column>=0){
//            if(board[row][column] == 'Q'){
//                return false;
//            }
//            row++;
//            column--;
//        }
//        return true;
//    }
    public static void solve(int column, List<List<String>> ans, char[][] board, int n, int[] leftRow, int[] leftLowerDiagonal, int[] leftUpperDiagonal){
        // Base case : if col == n then it mean we have filled all the queens
        if(column == n){
            // creating temporary list for storing the elements of particular row
            List<String> ds = new ArrayList<>();

            // adding characters from board array
            for(int row=0 ; row<n ; row++){
                String s = "";
                for(int col=0 ; col<n ; col++){
                    s += board[row][col];
                }
                ds.add(s);
            }

            // adding ds list into the final ans list
            ans.add(ds);
            return;
        }

        // recursive call
        for(int row=0 ; row<n ; row++){
            // checking if we can place queen or not : Brute force approach
//            if(canPlace_bruteForce(row, column, board, n)){
//                board[row][column] = 'Q';   // place the queen
//                solve(column+1, ans, board, n); // call recursion for column+1
//                board[row][column] = '.';   // remove the queen (Backtracking step)
//            }



            // Approach 2 : Optimised using Hashing : Search for valid place in just O(1) time
            // Optimised Approach using Hashing
            if(leftRow[row] == 0 && leftLowerDiagonal[row+column] == 0 && leftUpperDiagonal[(n-1)+(column-row)] == 0){
                // place the queen
                board[row][column] = 'Q';

                // fill the hash arrays with 1 - means there is a queen
                leftRow[row] = 1;
                leftLowerDiagonal[row+column] = 1;
                leftUpperDiagonal[(n-1)+(column-row)] = 1;

                // recursion call for next column
                solve(column+1, ans, board, n, leftRow, leftLowerDiagonal, leftUpperDiagonal);

                // Backtracking step : empty board and put 0 in hash arrays
                board[row][column] = '.';
                leftRow[row] = 0;
                leftLowerDiagonal[row+column] = 0;
                leftUpperDiagonal[(n-1)+(column-row)] = 0;
            }
        }
    }
    public static List<List<String>> solveQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        // creating empty board of size n*n
        char[][] board = new char[n][n];
        for(int row=0 ; row<n ; row++){
            for(int col=0 ; col<n ; col++){
                board[row][col] = '.';  // . means empty space
            }
        }


        // Hashing array for left row, left upper diagonal and left lower diagonal
        int[] leftRow = new int[n];
        int[] leftUpperDiagonal = new int[2*n-1];
        int[] leftLowerDiagonal = new int[2*n-1];

        // method definition : solve(column, ans, board, n)
        solve(0, ans, board, n, leftRow, leftLowerDiagonal, leftUpperDiagonal);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of testcases:");
        int numberOfTestcases = sc.nextInt();
        while (numberOfTestcases-- > 0){
            System.out.println("Enter the dimension of board(N):");
            int n = sc.nextInt();

            List<List<String>> finalBoard = solveQueens(n);
            for(List list : finalBoard){
                System.out.println(list);
            }
        }
    }
}
