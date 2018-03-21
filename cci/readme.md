This folder contains my implementation of different algorithms and data structures in Java.

## Usefull tips 

### Bit manipulation

- Test kth bit is set: num & (1 << k) != 0.
- Set kth bit: num |= (1 << k).
- Turn off kth bit: num &= ~(1 << k).
- Toggle the kth bit: num ^= (1 << k).
- To check if a number is a power of 2, num & num - 1 == 0.

### Linked list

Two pointer approaches are also common for linked lists. For example:

- Getting the kth from last node - Have two pointers, where one is k nodes ahead of the other. When the node ahead reaches the end, the other node is k nodes behind.
- Detecting cycles - Have two pointers, where one pointer increments twice as much as the other, if the two pointers meet, means that there is a cycle.
- Getting the middle node - Have two pointers, where one pointer increments twice as much as the other. When the faster node reaches the end of the list, the slower node will be at the middle.
