/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

int branchLength(Node p) {
    int c = 0;
    while (p != null) {
        c++;
        p = p.next;
    }
    return c;
}

int FindMergeNode(Node headA, Node headB) {
    int aLen = branchLength(headA);
    int bLen = branchLength(headB);
    Node pa = headA;
    Node pb = headB;
    while (aLen > bLen) { pa = pa.next; aLen--; }
    while (bLen > aLen) { pb = pb.next; bLen--; }
    while (pa != pb) {
        pa = pa.next;
        pb = pb.next;
    }
    return pa.data;
}
