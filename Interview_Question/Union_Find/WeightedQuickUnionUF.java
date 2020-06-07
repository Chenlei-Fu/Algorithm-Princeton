import java.util.Scanner;
public class WeightedQuickUnionUF {
	private final int id[];
    private final int sz[];
    private int componentNum;

    public WeightedQuickUnionUF(final int N) {
        // initialization
        componentNum = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return componentNum;
    }

    private int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]]; // path compression
            p = id[p];
        }
        return p;
    }

    public void union(final int p, final int q) {
        final int p_ = root(p);
        final int q_ = root(q);
        if (p_ == q_)
            return;
        if (sz[p_] < sz[q_]) {
            id[p_] = q_;
            sz[q_] += sz[p_];
        } else {
            id[q_] = p_;
            sz[p_] += sz[q_];
        }
        componentNum--;
    }

    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

}