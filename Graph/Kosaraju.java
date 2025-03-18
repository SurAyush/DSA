package Graph;
import java.util.*;
class Kosaraju
{
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer> st){
        vis[i] = true;
        for (int neigh: adj.get(i)){
            if (vis[neigh] == false){
                dfs(neigh,adj,vis,st);
            }
        }
        st.add(i);
    }
    
    public void dfs2(int i, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        vis[i] = true;
        for (int neigh: adj.get(i)){
            if (vis[neigh] == false){
                dfs2(neigh,adj,vis);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();     // order od finishing time
        // top: last finished
        boolean vis[] = new boolean[V];
        for (int i=0;i<V;i++){
            if (vis[i]==false)
                dfs(i,adj,vis,st);
        }
        // now we need to reverse all edges
    
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i=0;i<V;i++){
            rev.add(new ArrayList<>());
            vis[i] = false;
        }
        for(int i=0;i<V;i++){
            for(int j:adj.get(i)){
                rev.get(j).add(i);
            }
        }
        int scc = 0;
        // dfs in order of finshing time
        while(!st.isEmpty()){
            int el = st.pop();
            if (vis[el]==false){
                dfs2(el,rev,vis);
                scc++;
            }
        }
        
        return scc;

        // READ:::
        // initial order of finishing time is imp
        // if node x comes before y in the order -> this ensures in dfs traversal of normal graph we can reach from x to y (no guarantee from y to x maybe/maybe not)
        // so we run dfs in reversed graph in the same configuration (ordering).... (x is before y so we start from x. 
        // If we reach y, then x and y are strongly connected (we can reach x->y in org and x->y in reversed also (y->x in real graph)))
        // if we do randomly, say we explore y before, path from y->x may exist... but y->x may not be possible in original graph... So not strongly connected

    }
}

