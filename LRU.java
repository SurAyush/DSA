import java.util.HashMap;

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}
class LRUCache {

    Node head, tail;
    HashMap<Integer,Node> map;
    int c,ct;

    public LRUCache(int capacity) {
        ct = 0;
        c = capacity;
        map =  new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
    }
    
    public void removeNode (Node temp){
        map.remove(temp.key);
        if (temp.next == tail && temp.prev == head){
            head.next = null;
            tail.prev = null;
        }
        else{
            Node nextnode = temp.next;
            Node prevnode = temp.prev;
            nextnode.prev = prevnode;
            prevnode.next = nextnode;
        }
    }

    public void addNode(Node temp){
        map.put(temp.key, temp);
        if (head.next == null){
            temp.next = tail;
            temp.prev = head;
            head.next = temp;
            tail.prev = temp;
        }
        else{
            temp.next = head.next;
            temp.prev = head;
            (head.next).prev = temp;
            head.next = temp;
        }
    }


    // O(1)
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node temp = map.get(key);
            int val = temp.value;
            removeNode(temp);
            addNode(temp);
            return val;
        }
    }

    // O(1)
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            removeNode(temp);
            addNode(new Node(key,value));        
        }
        else{
            if (ct<c){
                Node newnode = new Node(key,value);
                addNode(newnode);
                ct++;
            }
            else{
                Node temp = tail.prev;
                removeNode(temp);
                Node newnode = new Node(key,value);
                addNode(newnode);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */