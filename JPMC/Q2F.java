package JPMC;

import java.util.*;

public class Q2F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        long cp = n;
        int d = 0;
        while(cp>0){
            d++;
            cp/=10;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        long newnum=0;
        String num = String.valueOf(n);
        int p1=0;
        int last = -1;
        while(p1<d){
            int dig = num.charAt(p1) - '0';
            if(dig%2==1){
                if(last==-1 || last==1){
                    arr.add(dig);
                    last = 1;
                }
                else{
                    arr.sort(Collections.reverseOrder());
                    for(int el: arr){
                        newnum = newnum*10+el;
                    }
                    arr.clear();
                    arr.add(dig);
                    last = 1;
                }
            }
            else if(dig%2==0){
                if(last==-1 || last==0){
                    arr.add(dig);
                    last = 0;
                }
                else{
                    arr.sort(Collections.reverseOrder());
                    for(int el: arr){
                        newnum = newnum*10+el;
                    }
                    arr.clear();
                    last = 0;
                    arr.add(dig);
                }
            }
            p1++;
        }
        arr.sort(Collections.reverseOrder());
        for(int el: arr){
            newnum = newnum*10+el;
        }

        System.out.println(newnum);

    }
}
