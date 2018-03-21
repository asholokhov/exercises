/*
  Delete Node at a given position in a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 

Node Delete(Node head, int position) {
    switch (position) {
        case 0:
            if (head == null) return null;
            else {
                head = head.next;
                return head;
            }
        default:
            Node c = head; int p = 0;
            while (c != null) {
                if (p + 1 == position) {
                    if (c.next != null && c.next.next != null) {
                        c.next = c.next.next;
                    } else {
                        c.next = null;
                    }
                    return head;
                }
                p++;
                c = c.next;
            }
    }
    return head;
}

