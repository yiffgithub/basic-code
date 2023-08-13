
package assignment4;

public class Q1 {
    public static int countWays(int[] S, int m, int n) {
        // Initialize a memoization table with -1
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return countWaysUtil(S, m, n, dp);
    }

    private static int countWaysUtil(int[] S, int m, int n, int[][] dp) {
        // If n is 0 then there is 1 solution (do not include any coin)
        if(n == 0) {
            return 1;
        }

        // If n is less than 0 then no solution exists
        if(n < 0) {
            return 0;
        }

        // If there are no coins and n is greater than 0, then no solution exist
        if(m <= 0 && n >= 1) {
            return 0;
        }

        // If the solution is already computed, return it
        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        dp[m][n] = countWaysUtil(S, m-1, n, dp) + countWaysUtil(S, m, n-S[m-1], dp);
        //System.out.println(dp[m][n]);

        return dp[m][n];
    }
// this is the test1
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int m = S.length;
        int n = 6;
     //   System.out.println(countWaysUtil(S,m,n,dp));
        System.out.println(countWays(S, m, n));  // Output: 7
// this is test 2
        S = new int[]{2, 5, 3, 6};
        m = S.length;
        n = 10;
        System.out.println(countWays(S, m, n));  // Output: 5
        // so the test is successful
    }
}
