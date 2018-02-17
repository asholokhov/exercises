// https://www.hackerrank.com/challenges/is-fibo
//

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IsFibo {

    List<Long> fibonacci = new LinkedList<Long>();

    public static void main(String[] args) {
        new IsFibo().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        fibonacci.add((long) 0);
        fibonacci.add((long) 1);
        for (int i = 2; i < 70; i++) {
            fibonacci.add(fibonacci.get(i - 2) + fibonacci.get(i - 1));
        }

        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            System.out.println(checkFibonacci(n) ? "IsFibo" : "IsNotFibo");
        }
    }

    private boolean checkFibonacci(long n) {
        return fibonacci.contains(n);
    }

}
