package Graph;
import java.util.*;
class  DisjointSet{
    int [] parents;
    int [] rank;
    int [] size;
    public DisjointSet(int n){
        // n: number of elements
            this.parents = new int[n];
            this.size = new int[n];
            for(int i=0;i<n;i++){
                parents[i] = i;
                size[i] = 1;
            }
    }
    public int find(int x){
        // X: whose ultimate parent we need to find
        // find with path compression
        if (parents[x] != x){
            parents[x] = find(parents[x]);  // path compression
            return parents[x];
        }
        return x;
    }
    public void union_size(int x, int y){
        int px = find(x);
        int py = find(y);
        // check if both have same parent
        if (px == py)
            return;
        else if (size[px]>size[py]){
            parents[py] = px;
            size[px] += size[py];
        }
        else{
            parents[px] = py;
            size[py] += size[px];
        }
    }
}

class Kruskals {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        DisjointSet dj = new DisjointSet(V);
        ArrayList<int []> li = new ArrayList<>();
        
        //adding all edges
        // O(E)
        for (int i=0;i<V;i++){
            int sz = adj.get(i).size();
            for (int j=0;j<sz;j++){
                li.add(new int[]{adj.get(i).get(j)[1],adj.get(i).get(j)[0],i});
            }
        }
        
        // O(ElogE)
        li.sort(Comparator.comparingInt((int a[])->a[0]));
        
        int sum=0;
        int earlystop = 0;
        
        // O(E*alpha)
        for (int arr[]: li){
            if (earlystop == V-1)  // number of edges of mst
                break;
            if (dj.find(arr[1]) != dj.find(arr[2])){
                dj.union_size(arr[1],arr[2]);
                sum += arr[0];
                earlystop++;
                // edge of NST: arr[1] & arr[2]
            }
        }
        
        return sum;
        
    }
}

