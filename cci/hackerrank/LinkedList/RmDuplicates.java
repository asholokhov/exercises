/*

Remove duplicates from sorted LL

Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

Node RemoveDuplicates(Node head) {
    if (head == null) return null;
    Node pa = head;
    while (pa.next != null) {
        if (pa.data == pa.next.data) {
            pa.next = pa.next.next;
        } else {
            pa = pa.next;
        }
    }
    return head;
}
