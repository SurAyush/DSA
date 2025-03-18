// import java.util.*;
// classic 0/1 knapsack problem
public class Knapsack {
    public static int knapsack(int [] wt, int [] val, int W, int n,int [][] dp){
        if (W==0){   // base case
            return 0;
        }
        if (n==0){   // base case
            if (wt[n]<=W){
                return val[n];
            }
            else{
                return 0;
            }
        }

        if (dp[n][W] != -1){
            return dp[n][W];
        }

        int take = Integer.MIN_VALUE;
        int not_take = knapsack(wt, val, W, n-1, dp);
        if (W>=wt[n]){
            take = knapsack(wt, val, W-wt[n], n-1, dp)+val[n];
        }
        dp[n][W] = Math.max(take, not_take);
        return dp[n][W];
    }
    public static void main(String[] args) {
        int [] wt = {1, 25, 24, 30};
        int [] val = {1, 50, 48, 60};
        int W = 50;
        int n = wt.length;   // last index
        int [][] dp = new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(wt, val, W, n-1,dp));
    }
}
