package Heaps;
// You need to implement the Min Heap with the following given methods.

// insert (x) -> insert value x to the min heap
// getMin -> Output the minimum value from min heap
// exctractMin -> Remove the minimum element from the heap
// heapSize -> return the current size of the heap
// isEmpty -> returns if heap is empty or not
// changeKey (ind, val) -> update the value at given index to val (index will be given 0-based indexing)
// initializeHeap -> Initialize the heap

public class MinHeap {
    int[] heap;
    int size = 1_000_00;
    int n;     // 1 based indexing

    public void initializeHeap() {
        heap = new int[size];
        n = 0;
    }

    public void heapifyUp(int idx){
        int parent = idx/2;
        int temp;
        while(idx>1 && heap[parent]>heap[idx]){
            // swap
            temp = heap[parent];
            heap[parent] = heap[idx];
            heap[idx] = temp;
            idx = parent;
            heapifyUp(idx);
        }
    }

    public void heapifyDown(int idx){
        int left = idx * 2;
        int right = idx * 2 + 1;
        int temp;
        int smallest = idx;
        if (left <= n && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right <= n && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if(smallest!=idx){
            // swap
            temp = heap[smallest];
            heap[smallest] = heap[idx];
            heap[idx] = temp;
            heapifyDown(smallest);
        }
    }

    public void insert(int key) {
        n += 1;
        if (n >= size) {
            // Resize the heap if necessary
            int[] newHeap = new int[size * 2];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
            size *= 2;
        }
        heap[n] = key;
        heapifyUp(n);
    }

    public void changeKey(int index, int newVal) {
        int oldVal = heap[index+1]; // 1-based indexing
        heap[index+1] = newVal; // 1-based indexing
        // to maintaine the heap property, we need to check if we need to heapify up or down
        if(newVal < oldVal) {
            heapifyUp(index + 1); 
        } else if (newVal > oldVal) {
            heapifyDown(index + 1); 
        }
    }

    public void extractMin() {
        // remove the top element
        heap[1] = heap[n];
        n--;
        heapifyDown(1);
    }

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        }
        return false;
    }

    public int getMin() {
       return heap[1];
    }

    public int heapSize() {
        return n;
    }
    public static void main(String[] args) {
        
    }
}
