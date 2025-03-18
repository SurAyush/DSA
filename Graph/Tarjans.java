package Graph;
import java.util.*;
class Tarjans {
    int time = 0;
    public void dfs(int n, int parent, boolean[] visited, int[] tov,int[] low, List<List<Integer>> graph , List<List<Integer>> bridges){
        visited[n] = true;
        low[n] = time;
        tov[n] = time;
        time++;
        for (int it: graph.get(n)){
            if (it == parent){
                continue;
            }
            if (visited[it] == false){
                dfs(it,n,visited, tov, low, graph, bridges);
                low[n] = Math.min(low[n], low[it]);            // not visited, my low = min(my low, its low)
                if (low[it]>tov[n]){
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(n);
                    li.add(it);
                    bridges.add(li);
                }
            }
            else{
                low[n] = Math.min(low[n],tov[it]);
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Tarjan's Algorithm
        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(new ArrayList<>());
        }
        for (List<Integer> con: connections){
            li.get(con.get(0)).add(con.get(1));
            li.get(con.get(1)).add(con.get(0));
        }
        List<List<Integer>> bridges = new LinkedList<>();
        boolean visited[] = new boolean[n];
        int tov[] = new int[n];       // time of visit
        int low[] = new int[n];      // earliest discovered node that can be reached from u (including back edges).
        // dfs from 0
        dfs(0,-1,visited,tov,low,li,bridges);
        return bridges;
    }
}
