package Graph;
import java.util.*;
class Shortest_Path_DAG {
    
    public void dfs(ArrayList<ArrayList<int []>> adj, boolean [] visited, Stack<Integer> topo, int start){
        visited[start] = true;
        for (int[] neigh: adj.get(start)){
            if (visited[neigh[0]]==false)
                dfs(adj,visited, topo, neigh[0]);
        }
        topo.add(start);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<int []>> adj = new ArrayList<>(N);
		for (int i=0;i<N;i++){
		    adj.add(new ArrayList<>());
		}
		for (int i=0;i<M;i++){
		    adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
		}
		
		Stack<Integer> topo = new Stack<>();
		boolean [] visited = new boolean[N];
		
		int [] dist = new int[N];
		dist[0] = 0;           // start
		for (int i=1;i<N;i++){
		    dist[i] = -1;
		}
		
		// all reachable components will be considered
		dfs(adj, visited, topo, 0);         // topo sorted
		
		while(!topo.isEmpty()){
		    int temp = topo.pop();
		    
		    for (int [] neigh: adj.get(temp) ){
		        if (dist[neigh[0]]==-1 || neigh[1] + dist[temp] < dist[neigh[0]]){
		            dist[neigh[0]] = neigh[1] + dist[temp];
		        } 
		    }
		}
		
		return dist;
	}
}
