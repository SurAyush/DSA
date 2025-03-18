package Stack;
import java.util.*;
public class Prefix2Postfix {
    public static String prefix2Postfix(String str){
        Stack<String> stack = new Stack<>();
        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch + "");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(op1 + op2 + ch);    // top1 top2 op
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println("Postfix: " + prefix2Postfix(prefix));
    }
}
