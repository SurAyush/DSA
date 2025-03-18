package Stack;

import java.util.Stack;

public class Infix2Prefix {
    public static int precedence(Character ch){
        if (ch=='+' || ch=='-') return 1;
        else if (ch=='*' || ch=='/') return 2;
        else if (ch=='^') return 3;
        else return -1;
    }
    public static String infix2Pretfix(String str){
        Stack<Character> stack = new Stack<>();
        String result = "";
        String rev = "";
        for(int i=str.length()-1;i>=0;i--){
            if (str.charAt(i)=='(')
                rev = rev + ')';
            else if (str.charAt(i)==')') 
                rev = rev + '(';
            else
                rev = rev + str.charAt(i);
        }
        for (int i=0;i<rev.length();i++){
            char ch = rev.charAt(i);
            if (Character.isLetterOrDigit(ch)) result += ch;
            else if (ch=='(') stack.push(ch);
            else if (ch==')'){
                while (!stack.isEmpty() && stack.peek()!='(') 
                    result += stack.pop();
                stack.pop();
            }
            else{
                while (!stack.isEmpty() && precedence(stack.peek())>precedence(ch)) 
                    result += stack.pop();
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) 
            result += stack.pop();

        String ans = "";

        for(int i=result.length()-1;i>=0;i--){
            ans = ans + result.charAt(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infix2Pretfix(infix));
    }
}
