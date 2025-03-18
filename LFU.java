import java.util.*;

class Node{
    int key,val,freq;
    Node next, prev;
    public Node(int key, int val, int freq){
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.next = null;
        this.prev = null;
    }
}

class DLL{
    Node head, tail;
    int size;
    public DLL(){
        size = 0;
        head = new Node(0,0,0);
        tail = new Node(0,0,0);
        head.next = tail;
        tail.prev = head;
    }

    // adds node to front
    public void addNode(Node newnode){
        Node temp = head.next;
        newnode.next = temp;
        newnode.prev = head;
        head.next = newnode;
        temp.prev = newnode;
        size++;
    }

    // removes node
    public void removeNode(Node currnode){
        Node prevnode = currnode.prev;
        Node nextnode = currnode.next;
        prevnode.next = nextnode;
        nextnode.prev = prevnode;
        size--;
    }
}

class LFUCache {

    HashMap<Integer, Node> cache;
    HashMap<Integer, DLL> freq_map;
    int capacity;
    int size;
    int min_freq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        freq_map = new HashMap<>();
        min_freq = 0;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        Node res = cache.get(key);
        DLL old_DLL = freq_map.get(res.freq);
        old_DLL.removeNode(res);
        if (res.freq == min_freq && old_DLL.size==0){
            min_freq++;
        }

        res.freq = res.freq + 1;

        DLL new_DLL;
        if (!freq_map.containsKey(res.freq))
            new_DLL = new DLL();
        else
            new_DLL = freq_map.get(res.freq);
        new_DLL.addNode(res);
        // if it contains it is fine, if it was empty:
        freq_map.put(res.freq, new_DLL);

        return res.val;
    }
    
    public void put(int key, int value) {

        if (cache.containsKey(key)){
            Node res = cache.get(key);
            res.val = value;
            DLL old_DLL = freq_map.get(res.freq);
            old_DLL.removeNode(res);
            if (res.freq == min_freq && old_DLL.size==0){
                min_freq++;
            }
            res.freq++;
            DLL new_DLL;
            if (!freq_map.containsKey(res.freq))
                new_DLL = new DLL();
            else
                new_DLL = freq_map.get(res.freq);
            new_DLL.addNode(res);
            freq_map.put(res.freq, new_DLL);
        }
        else{
            if (size<capacity){
                Node newnode = new Node(key,value,1);
                DLL new_DLL;
                if (!freq_map.containsKey(1))
                    new_DLL = new DLL();
                else
                    new_DLL = freq_map.get(1);
                new_DLL.addNode(newnode);
                freq_map.put(1, new_DLL);
                cache.put(key, newnode);
                size++;
                min_freq = 1;     // new node
            }
            else{
                // remove LFU node
                DLL target_DLL = freq_map.get(min_freq);
                Node target_node = target_DLL.tail.prev;
                target_DLL.removeNode(target_node);
                cache.remove(target_node.key);
                Node newnode = new Node(key,value,1);
                DLL new_DLL;
                if (!freq_map.containsKey(1))
                    new_DLL = new DLL();
                else
                    new_DLL = freq_map.get(1);
                new_DLL.addNode(newnode);
                freq_map.put(1, new_DLL);
                cache.put(key,newnode);
                min_freq = 1;       // newnode added
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */