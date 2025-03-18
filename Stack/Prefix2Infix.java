package Stack;
import java.util.Stack;
public class Prefix2Infix {
    public static String prefix2Infix(String exp){
        Stack<String> stack = new Stack<>();
        for (int i=exp.length()-1;i>=0;i--){
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) 
                stack.push(ch+"");
            else{
                System.out.println(ch);
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("("+op1+ch+op2+")");     // top1 operator top2
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String prefix = "+a*b-cd";
        System.out.println(prefix2Infix(prefix));
    }
}
