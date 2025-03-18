class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
class linkedlist{

    // Print LL
    public static int printLL(Node head){
        Node temp = head;
        int c=0;
        while(temp!=null){
            c++;
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
        return c;
    }

    // Linear Search
    public static boolean search(Node head, int key){
        Node temp = head;
        while (temp!=null){
            if(temp.data == key){
                System.out.println("Found");
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Not Found");
        return false;
    }

    // Insert at position k (0 based indexing)
    public static Node insert(Node head,int data,int pos){
        if (pos<0){
            System.out.println("Invalid Position");
            return head;
        }
        if (pos == 0){
            Node newnode = new Node(data);
            newnode.next = head;
            return newnode;
        }
        else{
            int c=0;
            Node newnode = new Node(data);
            Node temp = head;
            while(c<(pos-1)){
                c++;
                if (temp == null){
                    System.out.println("Position out of bound");
                    return head;
                }
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
            return head;
        }
    }

    // delete from postion k
    public static Node delNode(Node head, int pos){
        if (pos<0){
            System.out.println("Invalid position");
            return head;
        }
        if (pos == 0){
            Node temp = head.next;
            return temp;
        }
        else{
            int c=1;
            Node presNode, prevNode;
            presNode = head.next;
            prevNode = head;
            while(c<pos){
                c++;
                if (presNode.next!=null){
                    prevNode = presNode;
                    presNode = presNode.next;
                }
                else{
                    System.out.println("Invalid index");
                    return head;
                }
            }
            prevNode.next = presNode.next;
            return head;

        }
    }
 
    public static Node oddEvenSwapLL(Node head){
        Node oddhd = null, oddtail = null, evenhead = null, eventail=null;
        Node temp = head;
        while (temp!=null){
            if (temp.data%2==1){
                if(oddhd == null){
                    oddhd = new Node(temp.data);
                    oddtail = oddhd;
                }
                else{
                    oddtail.next = temp;
                    oddtail = temp;
                }
            }
            else{
                if(evenhead == null){
                    evenhead = new Node(temp.data);
                    eventail = evenhead;
                }
                else{
                    eventail.next = temp;
                    eventail = temp;
                }
            }
            temp = temp.next;
        }
        oddtail.next = evenhead;
        eventail.next = null;
        return oddhd;
    }
    
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node slow=head, fast=head, start = head;
        // LL cannot be cyclic
        // modified Tortoroise Hare Mehtod
        // fast ends at last node: always
        // slow: as it is
        
        // step 1: find slow and fast
        while(true){
            if (fast.next == null){
                break;
            }
            else if (fast.next.next == null){
                fast = fast.next;
                slow = slow.next;
                break;
            }
            else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        // reverse other half of LL
        Node prev = slow, pres = slow.next, fut = null;
        if (pres!=null){
            fut = pres.next;
        }
        prev.next = null;
        while(fut!=null){
            pres.next = prev;
            prev = pres;
            pres = fut;
            fut = fut.next;
        }
        if(pres!=null)
            pres.next = prev;
        
        // check (start & fast)
        while (true){
            if(fast == slow){
                if (start.data != fast.data){
                    return false;
                }
                break;
            }   // last comparison case
            System.out.println(start.data+" "+fast.data);
            if(start.data!=fast.data){
                return false;
            }
            start = start.next;
            fast = fast.next;
        }
        return true;
    }
    public static Node reverseLL (Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node prev = head,pres=head.next,fut = head.next.next;
        prev.next = null;
        while(fut!=null){
            pres.next = prev;
            prev = pres;
            pres = fut;
            fut = fut.next;
        }
        pres.next = prev;
        return pres;
    }
    public static Node addOne(Node head) {
        // code here.
        Node reversed = reverseLL(head);   // reverse the LL
        Node temp = reversed;
        int carry = 1;   // to add 1
        // add 1
        while(temp!=null && carry!=0){
            int x = carry + temp.data;
            carry = x>9?1:0;
            x = x%10;
            temp.data = x;
            temp = temp.next;
        }
        Node ans = reverseLL(reversed);
        if(temp==null && carry!=0){
            Node newnode = new Node(carry);
            newnode.next = ans;
            return newnode;
        }
        return ans;
            
    }

    public static void main(String[] args) {
        // creating a LL
        // Node sample = new Node(1);

        // create a LL from an array
        int[] arr = {9,9,9};
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i=1;i<arr.length;i++){
            Node newnode = new Node(arr[i]);
            temp.next = newnode;
            temp=temp.next;
        }
        head = addOne(head);
        // head = oddEvenSwapLL(head);
        // System.out.println(head.next.next.data);

        System.out.println(printLL(head));
        // System.out.println(isPalindrome(head));

        // search(head, 0);
        // head = insert(head, 0, 0);
        // head = insert(head, 24, 2);
        // System.out.println(printLL(head));
        // head = delNode(head, 0);
        // head = delNode(head, 1);
        // System.out.println(printLL(head));

        
    }
}