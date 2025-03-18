package Graph;
import java.util.*;
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Dijkstra {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        PriorityQueue<iPair> pq = new PriorityQueue<>(new Comparator<iPair>(){
            public int compare(iPair i, iPair j){
                return Integer.compare(i.first,j.first);
            }
        });
        int v = adj.size();
        ArrayList<Integer> dist = new ArrayList<>(v);
        // dist,node
        pq.add(new iPair(0,src));
        for (int i = 0;i<v;i++){
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(src,0);
        while(!pq.isEmpty()){
            iPair temp = pq.remove();
            // continue if dist[node] is already less
            if (temp.first > dist.get(temp.second))
                continue;
            for(iPair i: adj.get(temp.second)){
                if(temp.first + i.second < dist.get(i.first)){
                    dist.set(i.first,temp.first + i.second);
                    pq.add(new iPair(dist.get(i.first),i.first));
                }
            }
        }
        return dist;
    }
}