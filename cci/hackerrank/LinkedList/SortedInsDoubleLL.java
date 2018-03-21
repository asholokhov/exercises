/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

Node SortedInsert(Node head,int data) {
    Node n = new Node();
    n.data = data;
    if (head == null)
        return n;

    Node p = head;
    while (p != null) {
        if (p.data >= data) {
            Node t = p.prev;
            n.next = p;
            n.prev = t;
            p.prev = n;
            t.next = n;
            return head;
        }
        
        if (p.next == null) {
            n.prev = p;
            p.next = n;
            return head;
        }
    
        p = p.next;
    }
    
    return head;
}
