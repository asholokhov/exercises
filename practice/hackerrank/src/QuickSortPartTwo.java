// https://www.hackerrank.com/challenges/quicksort2
//

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSortPartTwo {

    public void quickSort(int[] arr, int lo, int hi) {
        int i = lo, j = hi, x = arr[(lo + hi)/2];
        while (i <= j) {
            while (arr[i] < x) i++;
            while (arr[j] > x) j--;
            if (i <= j) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                i++; j--;
            }
        }

        if (lo < j) quickSort(arr, lo, j);
        if (i < hi) quickSort(arr, i, hi);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        new QuickSortPartTwo().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
