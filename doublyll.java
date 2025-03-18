class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public Node(int data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
public class doublyll {

    public static int printDLL(Node head){
        Node temp = head;
        int c = 0;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
            c++;
        }
        System.out.println();
        return c;
    }

    public static boolean search(Node head, int key){
        Node temp = head;
        while(temp!=null){
            if(temp.data == key){
                System.out.println("Found");
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static Node insertNode(Node head, int data, int pos){
        if (pos<0){
            System.out.println("Invalid Position");
            return head;
        }
        if (pos == 0){
            // adding element at the start
            Node newnode = new Node(data);
            newnode.next = head;
            head.prev = newnode;
            return newnode;
        }
        else{
            int c = 0;
            Node temp = head;
            Node newnode = new Node(data);
            while(c<(pos-1)){
                if(temp == null){
                    System.out.println("Position out of bound");
                    return head;
                }
                temp = temp.next;
                c++;
            }
            // last element
            if (temp.next == null){
                temp.next = newnode;
                newnode.prev = temp;
                return head;
            }
            else{
                Node prev = temp.prev;
                prev.next = newnode;
                newnode.prev = prev;
                newnode.next = temp;
                temp.prev = newnode;
                return head;
            } 
        }
    }

    public static Node delNode(Node head, int pos){
        if (pos<0){
            System.out.println("Invalid position");
            return head;
        }
        if (pos==0){
            Node temp = head.next;
            temp.prev = null;
            return temp;
        }
        else{
            int c = 0;
            Node temp = head;
            while(c<pos){
                if (temp.next == null){
                    System.out.println("Invalid index");
                    return head;
                }
                temp = temp.next;
                c++;
            }
            // last element
            if (temp.next == null){
                temp.prev.next = null;
                return head;
            }
            else{
                Node prev = temp.prev;
                prev.next = temp.next;
                temp.next.prev = prev;
                temp = null;
                return head;
            }
        }
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5};
        Node head = new Node(arr[0]);
        Node temp = head;    // copy of reference
        for(int i=1;i<arr.length;i++){
            Node newnode = new Node(arr[i]);
            temp.next = newnode;
            newnode.prev = temp;
            temp = temp.next;
        }

        System.out.println(printDLL(head));
        System.out.println(search(head, 3));
        head = insertNode(head, 0, 0);
        head = insertNode(head, 6, 6);
        head = insertNode(head, 10, 3);
        System.out.println(printDLL(head));
        head = delNode(head, 0);
        head = delNode(head, 6);
        head = delNode(head, 3);
        System.out.println(printDLL(head));
        // reverse
    }
}
