package Stack;
import java.util.*;
public class Infix2Postfix {
    public static int precedence(Character ch){
        if (ch=='+' || ch=='-') return 1;
        else if (ch=='*' || ch=='/') return 2;
        else if (ch=='^') return 3;
        else return -1;
    }
    public static String infix2Postfix(String str){
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) result += ch;
            else if (ch=='(') stack.push(ch);
            else if (ch==')'){
                while (!stack.isEmpty() && stack.peek()!='(') 
                    result += stack.pop();
                stack.pop();
            }
            else{
                while (!stack.isEmpty() && precedence(stack.peek())>=precedence(ch)) 
                    result += stack.pop();
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) 
            result += stack.pop();

        return result;
    }
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infix2Postfix(infix));
    }
}
