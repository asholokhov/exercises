// https://www.hackerrank.com/challenges/maximizing-xor
//

import java.util.Scanner;

public class MaximizingXor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int r = in.nextInt();

        int max = 0;
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                if ((i ^ j) > max) {
                    max = i ^ j;
                }
            }
        }

        System.out.println(max);
    }

}
