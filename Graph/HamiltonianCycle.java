// package Graph;
public class HamiltonianCycle {

    public static boolean isSafe(int[][] graph, int[] path, int p, int i){
        // path does not exist
        if(graph[path[p-1]][i]==0)
            return false;
        
        for(int j=0;j<p;j++){
            if(path[j]==i){
                return false;
            }
        }

        return true;
    }

    public static boolean cycle(int[][] graph, int[] path, int p){
        if(p==graph.length){
            if(graph[path[p-1]][path[0]]!=0){
                path[p] = path[0];
                return true;
            }
            return false;
        }
        for(int i=0;i<graph.length;i++){
            if(isSafe(graph,path,p,i)==true){
                path[p] = i;
                if(cycle(graph, path, p+1)==true)
                    return true;
                path[p] = -1;    // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int graph1[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
        };
        // int graph2[][] = {{0, 1, 0, 1, 0},
        //     {1, 0, 1, 1, 1},
        //     {0, 1, 0, 0, 1},
        //     {1, 1, 0, 0, 0},
        //     {0, 1, 1, 0, 0},
        // };
        int v = graph1.length;
        int [] path = new int[v+1];
        for(int i=0;i<=v;i++)
            path[i] = -1;
        
        path[0] = 0;

        if(cycle(graph1, path, 1)==false)
            System.out.println("Not Possible");
        else{
            for(int i=0;i<=v;i++)
                System.out.print(path[i]+" ");
        }

    }
}
