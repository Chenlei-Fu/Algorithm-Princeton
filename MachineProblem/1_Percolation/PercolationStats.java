import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
public class PercolationStats {
    // perform independent trials on an n-by-n grid
    private int experiment_total = 0;
    private double probs[];
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        experiment_total = trials;
        probs = new double[experiment_total];
        // start calculation
        for (int i = 0; i < experiment_total; i++) {
            Percolation pr = new Percolation(n);
            while (!pr.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                pr.open(row, col);
            }
            probs[i] = (double) pr.numberOfOpenSites()/(n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(probs);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(probs);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(experiment_total));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(experiment_total));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percStats = new PercolationStats(n, trials);
        StdOut.println("mean                    = " + percStats.mean());
        StdOut.println("stddev                  = " + percStats.stddev());
        StdOut.println("95% confidence interval = [" + percStats.confidenceLo() + ", " + percStats.confidenceHi() + "]");
    }
}
