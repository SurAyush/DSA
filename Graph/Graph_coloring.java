public class Graph_coloring {
    public static boolean isSafe(boolean[][] graph, int[] color, int idx, int c){
        // path does not exist
        for(int i=0;i<graph.length;i++){
            if(graph[idx][i]==true && c==color[i]){
                return false;
            }
        }

        return true;
    }

    public static boolean color_graph(boolean[][] graph, int[] color, int m, int idx){
        if(idx==graph.length){
            return true;     // all colored
        }

        for(int i=1;i<=m;i++){
            if(isSafe(graph,color,idx,i)==true){
                color[idx] = i;
                if(color_graph(graph, color, m, idx+1)==true)
                    return true;
                color[idx] = 0;    // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] graph = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false }
        };

        // Number of colors
        int m = 3;
        int v = graph.length;

        int[] colors = new int[v];
        for(int i=0;i<v;i++)
            colors[i] = 0;       // uncolored

        if (!color_graph(graph, colors, m, 0))
            System.out.println("Not Possible");
        else{
            for(int i=0;i<v;i++){
                System.out.print(colors[i]+" ");
            }
        }
        
    }    
}
