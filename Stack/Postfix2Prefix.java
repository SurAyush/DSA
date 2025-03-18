package Stack;
import java.util.Stack;
public class Postfix2Prefix {
    public static String postfix2Prefix(String exp){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c + "");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(c + op2 + op1);     // op top2 top1
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String postfix = "ABC/-AK/L-*";
        System.out.println(postfix2Prefix(postfix));
    }
}
