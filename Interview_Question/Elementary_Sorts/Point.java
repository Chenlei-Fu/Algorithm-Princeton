import java.util.Arrays;

public class Point implements Comparable<Point>{
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (o.x > this.x) return -1;
        if (o.x < this.x) return 1;
        if (o.y > this.y) return -1;
        if (o.y < this.y) return 1;
        return 0;
    }

    public static int countIntersection(Point[] a, Point[] b) {
        // since we are talking about sort, I ignored HashSet method.
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0, count = 0, lenA = a.length, lenB = b.length;
        while (i < lenA && j < lenB) {
            if (a[i].compareTo(b[j]) == 0) {
                count++;
                i++;
                j++;
            } else if (a[i].compareTo(b[j]) < 0)
                i++;
            else
                j++;
        }
        return count;
    }

    public static void main(String[] args) {
        Point[] a = new Point[] { new Point(1, 2), new Point(1, 3), new Point(1, 4) };
        Point[] b = new Point[] { new Point(1, 3) };
        System.out.println(countIntersection(a, b));
    }
}