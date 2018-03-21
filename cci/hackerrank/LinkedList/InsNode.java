/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    

Node InsertNth(Node head, int data, int position) {
    Node n = new Node();
    n.data = data;
    switch (position) {
        case 0: 
            if (head != null) {
                n.next = head;
            }
            return n;
        default:
            Node c = head; int p = 0;
            while (c != null) {
                if (p + 1 == position) {
                    if (c.next != null) {
                        Node t = c.next;
                        c.next = n;
                        n.next = t;
                    } else {
                        c.next = n;
                    }
                    return head;
                }
                p++;
                c = c.next;
            }
    }
    return head;
}
