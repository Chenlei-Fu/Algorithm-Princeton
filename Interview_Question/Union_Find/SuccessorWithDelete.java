public class SuccessorWithDelete{
	private int id[];
    private int sz[];
    private int large[];
    private int N;
    private boolean isRemoved[]; // check if it's removed

    public SuccessorWithDelete(int N) {
        this.N = N;
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        isRemoved = new boolean[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
    }

    public boolean connected(int id1, int id2){
        return root(id1) == root(id2);
    }

    public int root(int p){
        while(id[p] != p){
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }
        return p;
    }

    public int find(int p){
        return large[root(p)];
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

    public void remove(int x){
        isRemoved[x] = true;
        if(x > 0 && isRemoved[x-1] == false){
            union(x, x-1);
        }
        if(x < N - 1 && isRemoved[x+1] == false){
            union(x, x+1);
        }
    }

    public int successor(int x){
        if(isRemoved[x] == false) return x;
        int res = find(x) + 1;
        if (res >= N && res < 0) return -1;
        else return res;
    }
    
    
}