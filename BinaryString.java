public class BinaryString {
    public static void gen(int i, String s, boolean flag){
        if (i==0){
            System.out.println(s);
            return;
        }
        if (flag){
            gen(i-1,s+"0",false);
        }
        else{
            gen(i-1,s+"0",false);
            gen(i-1,s+"1",true);
        }
    }
    public static void main(String[] args) {
        int k = 4;
        gen(k,"",false);
    }    
}
