import java.util.*;

public class CheckBST {

	class Node {
	    int data;
	    Node left;
	    Node right;
    }

    private static boolean go(Node node, int min, int max) {
    	if (node == null) return true;
    	if (node.data <= min || node.data >= max) return false;
    	return go(node.left, min, node.data) && go(node.right, node.data, max);
    }

    public static boolean checkBST(Node root) {
    	return go(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	public static void main(String[] args) {

	}

}