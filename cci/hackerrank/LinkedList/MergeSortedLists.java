int getNext(Node pa, Node pb) {
    if (pb == null) return 0;
    if (pa == null) return 1;
    return pa.data < pb.data ? 0 : 1;
  }

  Node mergeLists(Node headA, Node headB) {
    if (headA == null && headB == null)
      return null;

    Node pa = headA;
    Node pb = headB;

    Node rp = null;
    if (getNext(pa, pb) == 0) {
      rp = pa; pa = pa.next;
    } else {
      rp = pb; pb = pb.next;
    }

    Node rh = rp;
    while (pa != null || pb != null) {
      switch(getNext(pa, pb)) {
        case 0:
          rp.next = pa;
          pa = pa.next;
          break;
        case 1:
          rp.next = pb;
          pb = pb.next;
          break;
      }
      rp = rp.next;
    }

    return rh;
  }