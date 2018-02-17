import java.util.Scanner;

public class С_538_P_A {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        boolean[] col = new boolean[n];
        boolean[] row = new boolean[n];

        //

        for (int d = 0; d < n * n; d++) {
            int i = s.nextInt() - 1,
                j = s.nextInt() - 1;

            if( col[i] || row[j] ) {
                continue;
            }

            col[i] = row[j] = true;
            System.out.print((d + 1) + " ");
        }
    }

}
