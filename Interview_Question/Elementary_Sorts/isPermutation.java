import java.util.Arrays;

public class isPermutation {
    public static boolean isPerm(int[] a, int[] b) {
        int lenA = a.length, lenB = b.length;
        if(lenA != lenB) return false;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < lenA; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,3,2};
        int[] b = new int[]{2,1,3};
        System.out.println(isPerm(a, b));
    }
}