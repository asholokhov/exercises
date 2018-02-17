import java.util.*;
import java.util.stream.IntStream;

// todo: change file name for compilation
// Algorithms / Graph Theory / Journey to the Moon
public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> g.add(new ArrayList<>()));
        IntStream.range(0, p).forEach(i -> {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            g.get(from).add(to);
            g.get(to).add(from);
        });

        ArrayList<List<Integer>> lists = countComponents(g);
        List<Integer> partitions = lists.get(0);
        List<Integer> sums = lists.get(1);

        if (partitions.size() == 1) {
            System.out.println("0");
        } else {
            long ans = 0;
            for (int i = 0; i < partitions.size(); i++) {
                ans += partitions.get(i) * (sums.get(sums.size() - 1) - sums.get(i + 1 - 1));
            }
            System.out.println(ans);
        }
    }

    private ArrayList<List<Integer>> countComponents(List<List<Integer>> g) {
        boolean[] was = new boolean[g.size()];
        List<Integer> partitions = new ArrayList<>(g.size());
        List<Integer> preprocessed = new ArrayList<>(g.size());

        for (int v = 0; v < g.size(); v++) {
            if (was[v]) continue;
            int members = dfs(g, v, was);
            partitions.add(members);

            if (preprocessed.size() == 0) {
                preprocessed.add(members);
            } else {
                preprocessed.add(members + preprocessed.get(preprocessed.size() - 1));
            }
        }

        return new ArrayList<List<Integer>>() {{
            add(partitions);
            add(preprocessed);
        }};
    }

    private int dfs(List<List<Integer>> g, int v, boolean[] was) {
        int m = 0;
        if (was[v]) return m;
        was[v] = true;
        m++;
        for (int i = 0; i < g.get(v).size(); i++) {
            m += dfs(g, g.get(v).get(i), was);
        }
        return m;
    }

}
