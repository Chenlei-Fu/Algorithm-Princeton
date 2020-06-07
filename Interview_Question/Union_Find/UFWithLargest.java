public class UFWithLargest {
	private final int id[];
    private final int sz[];
    private final int large[];

    public UFWithLargest(final int N) {
        // initialization
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
    }

    public int find(int i) {
        return large[root(i)];
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
        final int large_p = large[p_];
        final int large_q = large[q_];
        if (sz[p_] < sz[q_]) {
            id[p_] = q_;
            sz[q_] += sz[p_];
            if(large_p > large_q) large[q_] = large_p;
        } else {
            id[q_] = p_;
            sz[p_] += sz[q_];
            if(large_p < large_q) large[p_] = large_q;
        }
    }

    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

}