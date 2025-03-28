public class Kadane {
    public static long kadane(int[] arr){
        // handle empty array case
        if(arr.length == 0) return 0;
        
        long sum = 0;
        long max = Long.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            max = Math.max(max, sum);

            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    } 
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,6,-25,10,15};
        long max = kadane(arr);
        System.out.println(max);
    }
}
