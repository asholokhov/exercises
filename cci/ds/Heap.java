import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> elements;

    public Heap(int[] source) {
        this.elements = new ArrayList<>(source.length);
        for (int e : source) {
            this.add(e);
        }
    }

    public void add(int e) {
        elements.add(e);
        this.heapUp(elements.size() - 1);
    }

    public int top() {
        return elements.size() == 0 ? -1 : elements.get(0);
    }

    public int getMax() {
        int res = this.top();
        if (elements.size() > 0) {
            elements.remove(0);
            if (elements.size() > 0) {
                int last = elements.get(elements.size() - 1);
                elements.remove(elements.size() - 1);
                elements.add(0, last);
                heapDown(0);
            }
        }
        return res;
    }

    // internals

    private void heapUp(int idx) {
        int p = parent(idx);
        if (elements.get(p) < elements.get(idx)) {
            swap(p, idx);
            heapUp(p);
        }
    }

    private void heapDown(int idx) {
        int largest = idx;
        int left = left(idx);
        int right = right(idx);
        
        if (elements.size() > left && elements.get(left) > elements.get(largest)) {
            largest = left;
        }
        if (elements.size() > right && elements.get(right) > elements.get(largest)) {
            largest = right;
        }

        if (largest == idx) return;
        swap(largest, idx);
        heapDown(largest);
    }

    private void swap(int i, int j) {
        int t = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, t);
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    // test

    public static void main(String[] args) {
        int s[] = {15, 12, 11, 18, 9, 24};
        Heap h = new Heap(s);
        for (int i = 0; i < 10; i++) {
            System.out.println("Current max: " + h.getMax());
        }
    }

}