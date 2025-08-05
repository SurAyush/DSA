/*
 * There are 2 approximate solution to metric TSP -- TSP with traingular inequality
 * - 2 approx: MST:  
 * - 1.5 approx: Christofides Algorithm
 * Code: https://www.geeksforgeeks.org/approximate-solution-for-travelling-salesman-problem-using-mst/
 * Lecture: https://www.youtube.com/watch?v=zM5MW5NKZJg
*/
import java.util.*;

public class TSP {

    public static int tsp(int [][] graph, boolean[] vis, int node, int idx){
        if(idx==graph.length){
            return graph[node][0]; // return to starting point
        }
        int ans = Integer.MAX_VALUE;
        int cost;
        for(int i=0; i<graph.length; i++){
            if(vis[i]==false){
                // visit i
                vis[i] = true;
                cost = graph[node][i] + tsp(graph, vis, i, idx+1);
                ans = Math.min(ans, cost);
                // backtrack
                vis[i] = false;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[][] graph = { { 0, 10, 15, 20 },
                         { 10, 0, 35, 25 },
                         { 15, 35, 0, 30 },
                         { 20, 25, 30, 0 } };
        
        int v = graph.length;
        boolean[] vis = new boolean[v];
        Arrays.fill(vis, false);

        int cost = tsp(graph,vis,0,0);
        System.out.println(cost);
    }
}
