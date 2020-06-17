

public class mergeWithSmaller{

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void mergeWithSmaller(Comparable[] a, Comparable[] aux) {
        int N = aux.length;
        assert a.length == 2 * N;

        for(int i = 0; i < N; i++) {
            aux[i] = a[i];
        }

        int l = 0, r = N;
        for(int i = 0; i < N; i++) {
            if(less(a[r], aux[i])) {
                a[i] = a[r++];
            } else {
                a[i] = aux[l++];
            }
        }

        while(l < N) {
            if (r >= 2*N || less(aux[l], a[r]) ) a[i++] = aux[l++];
            else a[i++] = a[r++];
        }
    }
}