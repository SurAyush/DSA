package JPMC;

import java.util.HashMap;
import java.util.Scanner;

public class Q1F {
    public static int countocc(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        int c=0;
        for(Integer key: map.keySet()){
            if(map.get(key)>1){
                c++;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] =sc.nextInt();
        }
        int ans = countocc(arr);
        sc.close();
        System.out.println(ans);
    }
}
