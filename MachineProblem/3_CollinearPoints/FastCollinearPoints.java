/* *****************************************************************************
 *  Name: Chenlei Fu
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> maxLineSegments = new ArrayList<>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        validate(points);
        Point[] sortedPoints = points.clone();
        // sort by position
        Arrays.sort(sortedPoints);
        int total = sortedPoints.length;
        for (int i = 0; i < total; i++) {
            Point p = sortedPoints[i];
            Point[] pointsBySlope = sortedPoints.clone();
            // sort by scope
            Arrays.sort(pointsBySlope, p.slopeOrder());
            int j = 1;
            while (j < total) {
                LinkedList<Point> candidates = new LinkedList<>();
                final double SLOPE_REF = p.slopeTo(pointsBySlope[j]);

                /*
                pay attention that we have sorted the point by SCOPE
                so the loop will break as long as p.slopeTo(temp) is not equal to the original one
                 */
                do {
                    candidates.add(pointsBySlope[j++]);
                } while (j < total && p.slopeTo(pointsBySlope[j]) == SLOPE_REF);

                if (candidates.size() >= 3 && p.compareTo(candidates.peek()) < 0) {
                    Point min = p;
                    Point max = candidates.removeLast();
                    maxLineSegments.add(new LineSegment(min, max));
                }
            }
        }

    }

    // the number of line segments
    public int numberOfSegments() {
        return maxLineSegments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return maxLineSegments.toArray(new LineSegment[0]);
    }

    private void validate(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (Point point: points) {
            if (point == null) throw new IllegalArgumentException();
        }
        // check duplicates
        int N = points.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++)
        {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) { p.draw(); }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments())
        {
            StdOut.println(segment);
            segment.draw();
            StdDraw.show();
        }
    }
}
