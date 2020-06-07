/* *****************************************************************************
 *  Name: Chenlei Fu
 *  Date: June 6
 *  Description:
 *  Note: By convention, the row and column indices are integers between 1 and n, where (1, 1) is the upper-left site
 **************************************************************************** */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    /**
     * Create n-by-n grid, with all sites blocked
     *
     * @param n length and width of the grid
     */
    private boolean isOpened[][];
    private int N;
    private int count_open = 0;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF backwashUF;


    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        isOpened = new boolean[n][n];
        N = n;
        uf = new WeightedQuickUnionUF(N * N + 2);
        backwashUF =  new WeightedQuickUnionUF(N * N + 1);
    }

    /**
     * Convert a 2D coordinate to 1D.
     *
     * @param row base-1 index of row
     * @param col base-1 index of column
     */
    private int indexOf(int row, int col) {
        // check bounds
        if (row <= 0 || row > N || col <= 0 || col > N) {
            return -1; // invalid
        }
        return (row - 1) * N + (col - 1) + 1; // note: based on 1
    }

    /**
     * Open site (row, col) if it is not open already
     */
    public void open(int row, int col) {
        isValid(row, col);
        if (isOpen(row, col)) return;
        isOpened[row-1][col-1] = true;
        count_open ++;
        int p = indexOf(row, col);
        if (row == 1) {
            uf.union(p, 0);
            backwashUF.union(p, 0);
        }
        if (row == N) {
            uf.union(p, N * N + 1);
        }
        int q;
        if (row > 1 && isOpen(row-1, col)) {
            q = indexOf(row-1, col);
            uf.union(p, q);
            backwashUF.union(p, q);
        }
        if (row < N && isOpen(row + 1, col)) {
            q = indexOf(row+1, col);
            uf.union(p, q);
            backwashUF.union(p, q);
        }
        if (col > 1 && isOpen(row, col - 1)) {
            q = indexOf(row, col-1);
            uf.union(p, q);
            backwashUF.union(p, q);
        }
        if (col < N && isOpen(row, col + 1)) {
            q = indexOf(row, col+1);
            uf.union(p, q);
            backwashUF.union(p, q);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isValid(row, col);
        return isOpened[row-1][col-1]; // note: based on 1
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!isOpen(row, col)) return false;
        int idx = indexOf(row, col);
        return (uf.find(idx) == uf.find(0)) && (backwashUF.find(idx) == backwashUF.find(0));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count_open;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(0) == uf.find(N * N + 1);
    }

    private void isValid(int n) {
        if (n <= 0 || n > N) {
            throw new IllegalArgumentException();
        }
    }

    private void isValid(int row, int col) {
        if (row <= 0 || row > N || col <= 0 || col > N) {
            throw new IllegalArgumentException();
        }

    }


}
