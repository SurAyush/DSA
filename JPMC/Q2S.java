package JPMC;
import java.util.*;
public class Q2S{
    public static void gen(String s,char inf){
        // String s = "d";
        int n = s.length();
        // char inf = 'd';

        // Find the first occurrence of 'd' from the end
        boolean found = false;
        int t=0, maxt=0;

        for(int i = n-1;i>=0;i--){
            if(found && s.charAt(i) == inf){
                t++;
                maxt = Math.max(t, maxt);
                t=0;
            }
            else if(s.charAt(i) == inf){
                maxt = Math.max(t, maxt);
                t=0;
                found = true;
            }
            else if(found){
                t++;
            }
        }
        
        maxt = Math.max(t, maxt);

        System.out.println(maxt);
    }
    public static void main(String[] args) {
        String[] arr = new String[]{"abc#d","a#bc#d","#","####","", "abc", "#a#b#c#d", "a#b##c#d##", "######abc"};
        char inf = '#';
        for(int i=0;i<arr.length;i++){
            gen(arr[i], inf);
        }
    }
}