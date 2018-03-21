import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrieContacts {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Trie t = new Trie();
    int n = in.nextInt();
    for(int a0 = 0; a0 < n; a0++){
      String op = in.next();
      String contact = in.next();
      if (op.equals("add")) {
        t.add(contact);
      } else {
        System.out.println(t.find(contact));
      }
    }
  }
}

class Trie {

  class Node {
    Map<Character, Node> children = new HashMap<>();
    int words = 0;
  }

  private Node root = new Node();

  public void add(String word) {
    Node c = this.root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!c.children.containsKey(ch)) {
        Node n = new Node();
        c.children.put(ch, n);
      }
      c = c.children.get(ch);
      c.words++;
    }
  }

  public int find(String prefix) {
    Node c = this.root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      c = c.children.get(ch);
      if (c == null) return 0;
    }
    return c.words;
  }

}