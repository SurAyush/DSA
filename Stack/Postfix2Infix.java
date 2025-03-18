package Stack;
import java.util.Stack;
public class Postfix2Infix {
    public static String postfix2Infix(String exp){
        Stack<String> stack = new Stack<>();
        for (int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) 
                stack.push(ch+"");
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("("+op2+ch+op1+")");     // top2 operator top1
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String postfix = "abc*+de*f+g*+";
        System.out.println(postfix2Infix(postfix));
    }
}
