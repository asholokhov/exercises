// https://www.hackerrank.com/challenges/quicksort1
//

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSortPartOne {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        List<Integer> left  = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        int p = list.get(0);

        for (Integer aList : list) {
            int e = aList;
            if (e >= p) right.add(e);
            else left.add(e);
        }

        for (Integer aLeft : left) System.out.print(aLeft + " ");
        for (Integer aRight : right) System.out.print(aRight + " ");
    }

}
