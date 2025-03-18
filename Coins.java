import java.util.*;
// RECURSION PROBLEM
// check TC plzz
public class Coins {

    public int min_coin(int [] coins, int amount){
        if (amount == 0)
            return 0;
        
        int res = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            if (coins[i]<=amount){
                int remaining = min_coin(coins, amount-coins[i]);

            if (remaining != Integer.MAX_VALUE && remaining+1 < res)
                res = remaining+1;
            }
        }

        return res;
    }

    public int num_of_ways(int [] coins, int n, int rem){
        // rem: remaining amount
        if (rem == 0)
            return 1;   // means one way

        if (n<0){
            return 0;  // out of bound
        }
        if (rem < 0)
            return 0;  // not a sol
        
        // case 1: include the last coin so updating n and rem
        // case 2: exclude the last coin so keeping n and rem same
        return num_of_ways(coins, n, rem-coins[n]) + num_of_ways(coins, n-1, rem);
    }

    public void all_ways(int [] coins, int n, int rem, List<List<Integer>> res, List<Integer> curr){
        // rem: remaining amount
        if (rem == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if (n<0){
            return;  // out of bound
        }
        if (rem < 0)
            return;  // not a sol
        
        // case 1: include the last coin so updating n and rem
        // case 2: exclude the last coin so keeping n and rem same
        curr.add(coins[n]);
        all_ways(coins, n, rem-coins[n], res, curr);

        curr.remove(curr.size()-1);
        all_ways(coins, n-1, rem,res, curr);
    }

    public static void main(String args[]) {
        int[] coins = {9, 6, 5, 1};
        int amount = 8;
        Coins obj = new Coins();
        List<List<Integer>> res = new ArrayList<>();
        System.out.println(obj.min_coin(coins, amount));
        System.out.println(obj.num_of_ways(coins, coins.length - 1, amount));
        obj.all_ways(coins, coins.length - 1, amount, res, new ArrayList<>());
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }    
}
