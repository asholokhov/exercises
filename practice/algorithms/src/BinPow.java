// Binary pow algorithm
//  complexity: O(log N)

public class BinPow {

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 15; j++) {
                System.out.println(i + "^" + j + " = " + BinPow.pow(i, j));
            }
        }
    }

    public static Long pow(Integer a, Integer n) {
        long degree = n.longValue();

        if (degree == 0) return (long) 1;
        if ((degree & 1) == 0) {
            long t = pow(a, n / 2);
            return t * t;
        } else {
            return a * pow(a, n - 1);
        }
    }

}
