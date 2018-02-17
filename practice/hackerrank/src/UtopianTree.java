// https://www.hackerrank.com/challenges/utopian-tree
//

import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {
        new UtopianTree().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int h = 1;
            int cycles = in.nextInt();

            for (int j = 0; j < cycles; j++) {
                h += (j % 2 == 0) ? h : 1;
            }

            System.out.println(h);
        }
    }

}
