/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
int GetNode(Node head,int n) {
    Node pf = head;
    Node ps = head;
    int d = 0;
    while (pf.next != null) {
        pf = pf.next; d++;
        if (d > n) {
            ps = ps.next;
        }
    }
    return ps.data;
}