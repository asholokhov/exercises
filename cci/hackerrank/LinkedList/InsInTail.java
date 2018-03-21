/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node Insert(Node head,int data) {
    Node c = head;
    while (c.next != null) {
        c = c.next;
    }
    Node nn = new Node();
    nn.data = data;
    nn.next = null;
    c.next = nn;
    return head;
}
