package Graph;
class  DisjointSet{
    int [] parents;
    int [] rank;
    int [] size;
    public DisjointSet(int n, String options){
        // n: number of elements
        if (options.equals("rank")){
            this.parents = new int[n];
            this.rank = new int[n];
            for(int i=0;i<n;i++){
                parents[i] = i;
                rank[i] = 0;
            }
        }
        else{
            this.parents = new int[n];
            this.size = new int[n];
            for(int i=0;i<n;i++){
                parents[i] = i;
                size[i] = 1;
            }
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
    public void union_rank(int x, int y){
        int px = find(x);
        int py = find(y);
        // check if both have same parent
        if (px == py)
            return;
        // check rank
        if (rank[px]>rank[py])
            parents[py] = px;
        else if (rank[px]<rank[py])
            parents[px] = py;
        else{
            parents[px] = py;
            rank[py]++;
        }   
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
public class Union_Find {
    public static void main(String[] args) {
        DisjointSet obj = new DisjointSet(7, "rank");
        System.out.println(obj.find(3));
        obj.union_rank(1, 2);
        obj.union_rank(2, 3);
        System.out.println(obj.find(3));
        obj.union_rank(4, 5);
        obj.union_rank(5, 6);
        System.out.println(obj.find(6));
        obj.union_rank(3, 6);
        System.out.println(obj.find(6));   
    }
}