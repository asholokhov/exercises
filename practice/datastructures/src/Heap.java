import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Heap {

    List<Integer> heap;

    private void heapUp(int index) {
        int parent = (index - 1) / 2;
        if (heap.get(index) > heap.get(parent)) {
            int t = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, t);

            heapUp(parent);
        }
    }

    private void heapDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < heap.size() && heap.get(largest) < heap.get(left)) {
            largest =  left;
        }

        if (right < heap.size() && heap.get(largest) < heap.get(right)) {
            largest = right;
        }

        if (largest == index) return;

        int t = heap.get(largest);
        heap.set(largest, heap.get(index));
        heap.set(index, t);

        heapDown(largest);
    }

    public void pushItem(int item) {
        heap.add(item);
        heapUp(heap.size() - 1);
    }

    public int getHeapTop() {
        int top = - 1;
        if (heap.size() > 0) {
            top = heap.get(0);
            heap.remove(0);
            if (heap.size() > 0) {
                heapDown(0);
            }
        }

        return top;
    }

    public void buildHeap(Integer[] arr) {
        heap = new ArrayList<>();
        for (Integer i : arr) {
            pushItem(i);
        }

        System.out.println(heap.toString());
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 7;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        Heap h = new Heap();
        h.buildHeap(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(h.getHeapTop());
        }
    }

}
