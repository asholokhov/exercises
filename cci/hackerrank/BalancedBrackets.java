import java.util.*;

public class BalancedBrackets {

	public static boolean isBalanced(String expression) {
		if (expression.length() % 2 != 0) {
			return false;
		}
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
        	char c = expression.charAt(i);
        	if (c == '(' || c == '{' || c == '[') {
        		s.push(c);
        	} else {
        		if (s.empty()) return false;
        		char top = s.pop();
        		switch (c) {
        			case ')': if (top != '(') return false; break;
        			case '}': if (top != '{') return false; break;
        			case ']': if (top != '[') return false; break;
        		}
        	}
        }
        return s.empty();
    }

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
	}

}