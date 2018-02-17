// https://www.hackerrank.com/challenges/find-digits
//

import java.util.Scanner;

public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int c = n;
            int answer = 0;

            while (c != 0) {
                int divider = (c % 10);
                if (divider != 0 && n % divider == 0) answer++;
                c /= 10;
            }

            System.out.println(answer);
        }
    }

}
