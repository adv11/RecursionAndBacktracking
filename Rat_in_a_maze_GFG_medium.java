package RecursionAndBacktracking;

import java.util.ArrayList;

/**
 *
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
 * Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up),
 * 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1
 * at a cell in the matrix represents that rat can be travel through it.
 * Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
 * Example 1:
 * Input:
 * N = 4
 * m[][] = {{1, 0, 0, 0},
 *          {1, 1, 0, 1},
 *          {1, 1, 0, 0},
 *          {0, 1, 1, 1}}
 * Output:
 * DDRDRR DRDDRR
 * Explanation:
 * The rat can reach the destination at
 * (3, 3) from (0, 0) by two paths - DRDDRR
 * and DDRDRR, when printed in sorted order
 * we get DDRDRR DRDDRR.
 * Example 2:
 * Input:
 * N = 2
 * m[][] = {{1, 0},
 *          {1, 0}}
 * Output:
 * -1
 * Explanation:
 * No path exists and destination cell is
 * blocked.
 * Your Task:
 * You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order.
 * Note: In case of no path, return an empty list. The driver will output "-1" automatically.
 *
 * Expected Time Complexity: O((3N^2)).
 * Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.
 *
 * Constraints:
 * 2 ≤ N ≤ 5
 * 0 ≤ m[i][j] ≤ 1
 */
public class Rat_in_a_maze_GFG_medium {

    // Brute Force Approach : using for loop for all directions separately
    public static void solve_bruteForce(int row, int col, int[][] m, int n, ArrayList<String> ans, boolean[][] visited, String string){
        // Base case
        if(row == n-1 && col == n-1){
            ans.add(string);
            return;
        }

        // downward direction
        if((row+1)<n && m[row+1][col] == 1 && !visited[row+1][col]){
            visited[row][col] = true;
            solve_bruteForce(row+1, col, m, n, ans, visited, string+"D");
            visited[row][col] = false;
        }

        // left direction
        if((col-1)>=0 && m[row][col-1] == 1 && !visited[row][col-1]){
            visited[row][col] = true;
            solve_bruteForce(row, col-1, m, n, ans, visited, string+"L");
            visited[row][col] = false;
        }

        // right direction
        if((col+1)<n && m[row][col+1] == 1 && !visited[row][col+1]){
            visited[row][col] = true;
            solve_bruteForce(row, col+1, m, n, ans, visited, string+"R");
            visited[row][col] = false;
        }

        // upper direction
        if((row-1)>=0 && m[row-1][col] == 1 && !visited[row-1][col]){
            visited[row][col] = true;
            solve_bruteForce(row-1, col, m, n, ans, visited, string+"U");
            visited[row][col] = false;
        }
    }

    // Optimised Approach : Only one loop for all 4 directions
    public static void solve_optimised(int row, int col, int[][] m, int n, ArrayList<String> ans, boolean[][] visited, String string, int[] di, int[] dj, String dir){
        // Base case
        if(row == n-1 && col == n-1){
            ans.add(string);
            return;
        }

        // loop for all 4 directions
        for(int index=0 ; index<4 ; index++){
            int nextRow = row + di[index];  // new row
            int nextCol = col + dj[index];  // new col

            if(nextRow>=0 && nextCol>=0 && nextRow<n && nextCol<n && !visited[nextRow][nextCol] && m[nextRow][nextCol] == 1){
                visited[row][col] = true;
                solve_optimised(nextRow, nextCol, m, n, ans, visited, string+dir.charAt(index), di, dj, dir);  // recursive call
                visited[row][col] = false;  // backtracking step
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] m = {{1, 0, 0, 0,},
                     {1, 1, 0, 1},
                     {1, 1, 0, 0},
                     {0, 1, 1, 1}};

        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        // for brute force approach : un-comment the below code
//        int row = 0, col = 0;
//        String string = "";
//
//        if(m[0][0] == 1){
//            solve_bruteForce(row, col, m, n, ans, visited, string);
//        }

        String string = "", dir = "DLRU";
        int row = 0, col = 0;
        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, +1, 0};
        if(m[0][0] == 1){
            solve_optimised(row, col, m, n, ans, visited, string, di, dj, dir);
        }
        System.out.println(ans);
    }
}
