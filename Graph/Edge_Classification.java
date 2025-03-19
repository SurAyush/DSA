package Graph;
import java.util.*;
public class Edge_Classification{
    static int time = 0;
    public static void dfs(int[][] graph, int node, boolean[] vis, int[] dis, int[] finish, List<int[]> li){
        vis[node] = true;
        dis[node] = time++;
        int neigh;
        for(int i=0;i<graph[node].length;i++){
            neigh = graph[node][i]; 
            if(vis[neigh]==false){
                // tree edge: 1
                li.add(new int[]{node,neigh,1});
                dfs(graph,neigh,vis,dis,finish,li);
            }
            else{
                // if it is still in recursion stack: cycle  ---> back edge: 2
                // still in stack finish[neigh]==-1 and vis[neigh]==true
                if(finish[neigh]==-1){
                    li.add(new int[]{node,neigh,2});
                    continue;
                }
                // if it is finished: 2 options
                // dis[neigh]>dis[node] --> forward: 1
                // dis[neigh]<dis[node]  --> cross edge: 3
                if(dis[neigh]>dis[node]){
                    li.add(new int[]{node,neigh,3});
                }
                else{
                    li.add(new int[]{node,neigh,4});
                }
            }
        }

        finish[node]=time++;
    }
    public static List<int[]> classify(int[][] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        int[] finish = new int[n];
        for(int i=0;i<n;i++){
            dis[i] = -1;
            finish[i] = -1;
        }

        List<int[]> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(graph,i,vis,dis,finish,li);
            }
        }

        return li;
    }
    public static void main(String[] args) {
        int[][] adj = {
            {1, 2, 7},     
            {3},     
            {4},       
            {5}, 
            {3, 6, 7},
            {1},
            {},
            {}
        };
        
        List<int[]> edges = classify(adj);

        // tree: 1, back: 2, forward: 3, cross:4

        for(int [] arr: edges){
            if(arr[2]==1){
                System.out.println("Tree Edge: "+arr[0]+" -> "+arr[1]);
            }
            else if(arr[2]==2){
                System.out.println("Back Edge: "+arr[0]+" -> "+arr[1]);
            }
            else if(arr[2]==3){
                System.out.println("Forward Edge: "+arr[0]+" -> "+arr[1]);
            }
            else{
                System.out.println("Cross Edge: "+arr[0]+" -> "+arr[1]);
            }
        }
    }
}