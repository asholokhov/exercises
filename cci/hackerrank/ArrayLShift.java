import java.util.*;

public class ArrayLShift {

	// extra space O(n)
	public static long[] shift(long[] arr, int d) {
		if (d == 0 || d == arr.length) return arr;
		long shifted[] = new long[arr.length];
		System.arraycopy(arr, d, shifted, 0, arr.length - d);
		System.arraycopy(arr, 0, shifted, arr.length - d, d);
		return shifted;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int d = s.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			// inline compute of new item place
			// where (n - d) is start index of shifted arr
			int npos = (i + (n - d)) % n;
			arr[npos] = s.nextLong();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}