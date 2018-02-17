import java.util.Scanner;

public class С_538_P_B {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] parts = new int[n];
        for(int i = 0; i < n; i++) {
            parts[i] = s.nextInt();
        }

        //

        int ans = 0;
        int idx = 0;
        int col = 0;
        int del = 1;

        while(col != n) {
            if (parts[idx] >= 0 && parts[idx] <= col) {
                col++;
                parts[idx] = -1;

                if(col == n) break;
            }

            idx += del;
            if(idx >= parts.length || idx < 0) {
                ans++;
                del = -del;
                idx += del;
            }
        }

        //

        System.out.println(ans);
    }

}
