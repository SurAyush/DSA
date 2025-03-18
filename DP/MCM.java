package DP;

public class MCM {
    static int mcm(int i, int j, int[] arr, int[][] dp){
        // matrices numbered from 0 to n-1
        // return the number of mul. from marix(i) to matrix(j) where i,j are indices and both inclusive
        if (i==j){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        // left part: (i,k)  right part: (k+1,j)
        // k from i to j-1
        int min = (int)1e9;
        for (int k=i;k<j;k++){
            int left = mcm(i,k,arr,dp);         // res dim: (arr[i], arr[k+1])
            int right = mcm(k+1,j,arr,dp);      // res dim: (arr[k+1], arr[j+1])
            min = Math.min(min, left + right + (arr[i] * arr[k+1] * arr[j+1]));
        }
        return dp[i][j] = min;
    }

    public static void printOptimalParenthesis(int[][] split, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }
        System.out.print("(");
        printOptimalParenthesis(split, i, split[i][j]); // Left part
        printOptimalParenthesis(split, split[i][j] + 1, j); // Right part
        System.out.print(")");
    }

    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length - 1;    // number of matrices
        int[][] dp = new int[n][n];
        int[][] split = new int[n][n];
        // for (int i=0;i<n;i++){
        //     for (int j=0;j<n;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        
        // memoization
        // return mcm(0,n-1,arr,dp);
        
        // tabulation
        // i==j : 0
        // i>j: 1e9
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==j)
                    dp[i][j] = 0;
            }
        }
        
        for (int i=n-1;i>=0;i--){
            for (int j = i+1;j<=n-1;j++){
                dp[i][j] = Integer.MAX_VALUE;
                int cost;
                for (int k=i;k<j;k++){
                    int left = dp[i][k];
                    int right = dp[k+1][j];
                    cost = left + right + (arr[i]*arr[k+1]*arr[j+1]);
                    if (cost<dp[i][j]){
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }
        printOptimalParenthesis(split, 0, n-1);
        System.out.println();
        // for(int i=0;i<n;i++){
        //     for (int j=0;j<n;j++){
        //         System.out.print(split[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n-1];
        
    }
    
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30,10};
        System.out.println(matrixMultiplication(arr));
    }
}
