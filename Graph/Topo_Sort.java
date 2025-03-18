package Graph;
import java.util.*;
class Topo_Sort {
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited, ArrayList<Integer> topo, int i){
        visited[i] = true;
        for(int j: adj.get(i)){
            if (visited[j]==false){
                dfs(adj,visited,topo,j);
            }            
        }
        topo.add(i);
    }
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int v = adj.size();
        ArrayList<Integer> topo = new ArrayList<>(v);
        // boolean [] visited = new boolean[v];
        // for(int i=0;i<v;i++){
        //     if (visited[i]==false)
        //         dfs(adj,visited,topo,i);
        // }
        // Collections.reverse(topo);
        // return topo;
        
        // Kahn's algorithm
        int indegree[] = new int[v];
        for (int i=0;i<v;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<v;i++){
            if (indegree[i]==0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int t = q.remove();
            // breaking it's edges with others
            for (int i: adj.get(t)){
                indegree[i]--;
                if (indegree[i]==0)
                    q.add(i);
            }
            topo.add(t);
        }
        
        return topo;
    }
}