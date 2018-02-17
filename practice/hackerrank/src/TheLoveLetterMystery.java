import java.util.Scanner;

public class TheLoveLetterMystery {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            String s = in.next();
            int count = 0;
            for (int j = 0; j < s.length() / 2; j++) {
                char first = s.charAt(j);
                char last  = s.charAt(s.length() - j - 1);
                count += Math.abs(first - last);
            }

            System.out.println(count);
        }
    }

}
