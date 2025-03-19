/*
 * There are 2 approximate solution to metric TSP -- TSP with traingular inequality
 * - 2 approx: MST:  
 * - 1.5 approx: Christofides Algorithm
 * Code: https://www.geeksforgeeks.org/approximate-solution-for-travelling-salesman-problem-using-mst/
 * Lecture: https://www.youtube.com/watch?v=zM5MW5NKZJg
*/
package Graph;
public class TSP {
    public static int tsp(int[][] graph, int vis, int c,int node){
        if(c==graph.length-1){
            // all nodes visited
            return graph[node][0];
        }

        int best = Integer.MAX_VALUE;
        for(int i=0;i<graph.length;i++){
            if(((1<<i)&vis)==0){
                // not yet visited
                // check path existence (here everything exist)
                // vis[i] = true;
                best = Math.min(best, graph[node][i] + tsp(graph, vis | (1<<i), c+1, i));
                // vis[i] = false;
            }
        }

        return best;
    }
    public static void main(String[] args) {
        int[][] graph = { { 0, 10, 15, 20 },
                         { 10, 0, 35, 25 },
                         { 15, 35, 0, 30 },
                         { 20, 25, 30, 0 } };
        
        int v = graph.length;
        // for DP
        // mask var: v boolean digits
        // dp[mask][c]
        // SC: (2^n * n)
        // TC: (n2*2^n)    from n!
        // boolean[] vis = new boolean[v];
        // vis[0] = true;
        int vis = 1;

        int cost = tsp(graph,vis,0,0);
        System.out.println(cost);
    }
}
