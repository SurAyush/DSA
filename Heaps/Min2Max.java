package Heaps;

public class Min2Max {
    public static void heapifyDown(int[] heap, int idx){
        int left  = idx * 2 + 1; 
        int right = idx * 2 + 2; 
        int temp;
        int max = idx;
        if(left<heap.length && heap[left]>heap[max]){
            max = left;
        }
        if(right<heap.length && heap[right]>heap[max]){
            max = right;
        }
        if(max!=idx){
            temp = heap[max];
            heap[max] = heap[idx];
            heap[idx] = temp;
            heapifyDown(heap, max);
        }
    }
    public static void minTomax(int[] heap){
        // heap is a min-heap
        int n = heap.length;
        for(int i = n/2;i>=0;i--){
            heapifyDown(heap, i);
        }
    }
    public static void main(String[] args) {
        int[] minHeap = {1, 3, 2, 7, 9, 5};
        minTomax(minHeap);
        System.out.print("Converted Max-Heap: ");
        for(int i : minHeap){
            System.out.print(i + " ");
        }
    }
}
