import java.util.*;
public class AllPermutaions {
    static void gen_all(List<List<Integer>> li, int[] comb, int index){
        // base case
        if (index == comb.length){
            List<Integer> temp = new ArrayList<>(index);
            for(int i =0;i<comb.length;i++){
                temp.add(comb[i]);
            }
            li.add(temp);
            return;
        }
        for (int i=index;i<comb.length;i++){
            swap(comb,i,index);
            gen_all(li, comb, index+1);
            swap(comb,i,index);
        }
    }
    static void swap(int[] comb, int i, int j){
        int temp = comb[i];
        comb[i] = comb[j];
        comb[j] = temp;
    }
    public static void main(String[] args) {
        // TC: O(n*n!)
        int[] comb = {1,2,3,4};
        List<List<Integer>> li = new ArrayList<>();
        gen_all(li, comb, 0);
        for(List<Integer> l: li){
            System.out.println(l);
        }
    }
}
