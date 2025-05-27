package Heaps;
public class IsHeap {
    public static boolean isMinHeap(int [] arr){
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            int left = i*2 + 1;
            int right = i*2 + 2;
            if(left<n && arr[left]<arr[i]){
                return false;
            }
            if(right<n && arr[right]<arr[i]){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] heap = {10, 20, 30, 25, 15}; 
        boolean result = isMinHeap(heap);
        System.out.println("Is the array a min-heap? " + result); 

        int[] heap2 = {1, 3, 2, 7, 9, 5}; 
        boolean result2 = isMinHeap(heap2);
        System.out.println("Is the array a min-heap? " + result2); 

        int[] heap3 = {10, 20, 30, 21, 23};
        boolean result3 = isMinHeap(heap3);
        System.out.println("Is the array a min-heap? " + result3);
    }
}
