// https://www.hackerrank.com/challenges/tutorial-intro
//

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TutorialIntro {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(),
            n = in.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo)/2;
            int e = list.get(m);

            if (v > e) lo = m + 1;
            if (v < e) hi = m - 1;
            if (v == e) {
                System.out.println(m);
                break;
            }
        }
    }

}
