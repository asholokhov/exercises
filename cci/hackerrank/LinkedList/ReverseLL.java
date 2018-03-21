/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
Node Reverse(Node head) {
    if (head == null) return null;
    Node c = head.next;
    Node p = head;
    p.next = null;
    while (c != null) {
        Node nx = c.next;
        c.next = p;
        p = c;
        c = nx;
    }
    return p;
}
