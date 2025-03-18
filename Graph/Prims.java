package Graph;
import java.util.*;
class Prims {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean visited[] = new boolean[V];
        int sum=0;
        int earlystop = 0;
        
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator <int[]>(){
            //override
            public int compare(int[] a, int[] b) {
                // Compare based on the first element of the arrays
                return Integer.compare(a[0], b[0]);
            }
        });
        // edge wt, parent, node
        
        // connected graph
        // let's begin at 0
        pq.add(new int[]{-1,0,0});
        
        // V log (V) + E
        while (!pq.isEmpty()){
            
            if (earlystop == V){
                break;
            }
            
            int [] temp = pq.remove();
            if (temp[0]!=-1){
                if (visited[temp[2]]==false){
                    visited[temp[2]] = true;
                    sum += temp[0];
                    earlystop++;
                    // edge of MST: temp[1] & temp[2]
                }
            }
            else{
                visited[temp[2]] = true;
                earlystop++;
            }
            for (int[] neigh: adj.get(temp[2])){
                if (visited[neigh[0]]==false){
                    pq.add(new int[]{neigh[1], temp[2],neigh[0]});  //wt,parent,node
                }
            }
        }
        
        return sum;
        
    }
}