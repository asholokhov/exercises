import java.lang.*;

// Don't use generics here for simplicity.
// 
public class ArrayList {

    private Object elements[];
    private int capacity;
    private int size;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public void add(Object e) {
        if (this.size + 1 > this.capacity) {
            resize(this.capacity * 2);
        }
        this.elements[size++] = e;
    }

    public Object get(int idx) throws Exception {
        if (idx >= size) {
            throw new Exception("Index out of bounds");
        }
        return this.elements[idx - 1];
    }

    public void remove(int idx) throws Exception {
        if (idx >= size) {
            throw new Exception("Index out of bounds");
        }
        for (int i = idx; i < size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i] + " ");
        }
        return sb.toString();
    }

    private void resize(int nc) {
        Object arr[] = new Object[nc];
        System.arraycopy(elements, 0, arr, 0, size);
        this.capacity = nc;
        this.elements = arr;
        System.out.println("ArrayList new capacity: " + this.capacity);
    }

    //

    public static void main(String[] args) {
        try {
            ArrayList list = new ArrayList();
            for (int i = 0; i < 30; i++) {
                list.add(i);
            }
            System.out.println(list.toString());
            for (int i = 1; i <= 5; i++) {
                list.remove(0);
            }
            System.out.println(list.toString());
        } catch(Exception e) {
            System.out.println(e);
        } 
    }

}