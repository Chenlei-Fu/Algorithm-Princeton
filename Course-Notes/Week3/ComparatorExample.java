import java.util.Comparator;
public class ComparatorExample {

    // Comparator supports multiple ordering of a given data type (Compare to "Comparable")
    
    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for(int i = 0; i < N; i++) {
            for(int j = i; j > 0 && less(comparator, a[i], a[j]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // we should implement comparator with nested class

}