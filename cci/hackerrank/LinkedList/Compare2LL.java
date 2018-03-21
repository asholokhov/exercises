/*
  Compare two linked lists A and B
  Return 1 if they are identical and 0 if they are not. 
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int CompareLists(Node headA, Node headB) {
    Node pa = headA;
    Node pb = headB;
    while (pa != null || pb != null) {
        if (pa == null && pb != null) return 0;
        if (pb == null && pa != null) return 0;
        if (pa.data != pb.data)       return 0;
        pa = pa.next;
        pb = pb.next;
    }
    return 1;
}
