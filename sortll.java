// sort singly link list
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node (int data,Node next){
        this.data = data;
        this.next = next;
    }
}
public class sortll {

    public static void printLL(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node merge(Node lefthead, Node righthead){
        Node p1 = lefthead, p2 = righthead;
        Node dummyNode = new Node(0);
        Node temp = dummyNode;
        while(p1!=null && p2!=null){
            if(p1.data<=p2.data){
                temp.next = p1;
                // first move p1 to next node and then move temp to next node
                p1 = p1.next;
                temp = temp.next;   
            }
            else{
                temp.next = p2;
                p2 = p2.next;
                temp = temp.next;
            }
        }
        while(p1!=null){
            temp.next = p1;
            p1 = p1.next;
            temp = temp.next;
        }
        while (p2!=null) {
            temp.next = p2;
            p2 = p2.next;
            temp = temp.next;
        } 
        return dummyNode.next;
    }
    public static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node slow=head, fast=head.next;
        // to divide O(n)
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node lefthead = head;
        Node righthead = slow.next;
        slow.next = null;   // breaking the LL
        lefthead = mergeSort(lefthead);
        righthead = mergeSort(righthead);
        // conquer O(n)
        head = merge(lefthead, righthead);
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(87);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(52);
        head.next.next.next.next.next = new Node(0);
        printLL(head);
        head = mergeSort(head);
        printLL(head);
    }
}
