import java.util.Stack;

class test {
        public String removeKdigits(String num, int k) {
            // Optimal
            // we try to keep small digits at higher place value positions
            // take a monotnoic stack
            // K: pop allowed (removal)
            // if digits are increasing then ok
            // if decreasing pop out char
            // 321999 k = 3
            // stack: 3  -> 2 < 3 (2 is a better start) stack: 2 k = 2  -> 1 < 2 (1 is a better start)  stack: 1 k=1 -> 9 > 1 stack: 1 9 k =1
            // 9 == 9 (no replacement to betterment) stack: 1 9 9 k =1 -> stack: 1 9 9 9  k=1
            // remove k rem: stack: 199
    
    
            int n = num.length();
            if (k==n)
                return "0";        // edge case
    
            char arr[] = new char[n-k];
            Stack<Character> st = new Stack<>();
            char ch;
            for(int i=0;i<n;i++){
                ch = num.charAt(i);
                if(!st.isEmpty() && st.peek()>ch && k>0){
                   System.out.println(st.pop());
                    k--;
                    System.out.println("k: "+k);
                    System.out.println("st: "+st);
                    System.out.println("ch: "+ch);
                }
                st.push(ch);
            }
            while(k>0){
                st.pop();
                k--;
            }
    
            for(int i=arr.length-1;i>=0;i--)
                arr[i] = st.pop();
            
            // reverse
            String res = new String(arr);
            
            // remove initial 0s
            int idx = 0;
            for(int i=0;i<res.length();i++){
                if (res.charAt(i)=='0')
                    idx = i+1;
                else
                    break;
            }
            
            // if all rem are 0
            if (idx == res.length())
                return "0";
    
            return res.substring(idx);
    
    
        }
    public static void main(String[] args) {
        int k = 9;
        String num = "1234567890";
        test t = new test();
        System.out.println(t.removeKdigits(num, k));
    }
}
