import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int best_seq(int n,ArrayList<int []> list, HashMap<Integer, Integer> map, int count, ArrayList<Integer> ds, int [] bits){
        
        if(n<=0){
            return count;
        }
        
        // take and not take
        
        int take=0, not_take;
        not_take = best_seq(n-1,list,map,count,ds,bits);
        boolean iftake = true;
        int [] temp = list.get(n);
        for(int i=0;i<32;i++){
            if(temp[i]==1 && bits[i]==1){
                iftake = false;
                break;
            }
        }
        
        if(!iftake){
            return not_take;
        }
        else{
            for(int i=0;i<32;i++){
                if(temp[i]==1)
                    bits[i] = 1;
            }
            ds.add(map.get(n));
            take = best_seq(n-1,list,map,count+1,ds,bits);
        }
        
        return Math.max(take,not_take);
    }
        
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m,n;
        while(t-->0){
            n = sc.nextInt();
            m = sc.nextInt();
            int c=0;
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<int []> list = new ArrayList<>();
            for(int i=0;i<=m;i++){
                if((i&n)==n && (i|n)==i){
                    int [] temp = new int[32];
                    for(int j=0;j<32;j++){
                        if((n&(1<<j))==0 && (i&(1<<j))==1){
                            temp[j] = 1;
                        }
                        else{
                            temp[j] = 0;
                        }
                    }
                    list.add(temp);
                    map.put(c,i);
                    c++;
                }
            }
            System.out.println(list.get(0)[0]);

            ArrayList<Integer> res = new ArrayList<>();
            int[] bits = new int[32];
            
            int count = best_seq(c-1,list, map, 0, res, bits);
            if(count == 0){
                System.out.println(-1);
            }
            else{
                System.out.println(count);
                for(int i=0;i<res.size();i++){
                    System.out.print(res.get(i));
                }
                System.out.println();
            }
        }
	}
}
