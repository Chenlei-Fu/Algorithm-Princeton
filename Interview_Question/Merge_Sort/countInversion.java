import java.util.Arrays;
public class countInversion {
    private static int merge(int[] a, int[] left, int[] right) {
        int i = 0, j = 0, llen = left.length, rlen = right.length, count = 0;
        while(i < llen || j < rlen) {
            if(i == llen) {
                a[i+j] = right[j];
                j++;
            } else if(j == rlen) {
                a[i+j] = left[i];
                i++;
            } else if(left[i] <= right[j]) {
                a[i+j] = left[i];
                i++;
            } else {
                a[i+j] = right[j];
                count += llen - i;
                j++;
            }
        }
        return count;
    }

    public static int invCount(int[] arr) {
        if (arr.length < 2) return 0;
        int m = (arr.length + 1) / 2;
        int left[] = Arrays.copyOfRange(arr, 0, m);
        int right[] = Arrays.copyOfRange(arr, m, arr.length);
        return invCount(left) + invCount(right) + merge(arr, left, right);
    } 

    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 1, 14, 8, 12, 3, 2};
        System.out.println(invCount(arr));
    }
}