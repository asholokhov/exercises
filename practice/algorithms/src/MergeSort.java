import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    public void merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[arr.length];
        int p_1 = lo;
        int p_2 = mid + 1;
        int p_t = 0;

        while (p_1 <= mid && p_2 <= hi) {
            temp[p_t++] = (arr[p_1] < arr[p_2]) ? arr[p_1++] : arr[p_2++];
        }

        while (p_1 <= mid) temp[p_t++] = arr[p_1++];
        while (p_2 <= hi) temp[p_t++] = arr[p_2++];

        p_t = 0;
        for (int i = lo; i <= hi; i++) {
            arr[i] = temp[p_t++];
        }
    }

    public void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;

            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        new MergeSort().mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
