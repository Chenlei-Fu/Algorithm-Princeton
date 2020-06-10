import java.util.*;
public class threeSum{
    public static List<List<Integer>> solution(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        int len = num.length;
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || i > 0 && num[i] != num[i - 1]) {
                int lo = i + 1, hi = len - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        lo++;
                    } else {
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num;
        num = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = new ArrayList<>();
        res = solution(num);
        System.out.println(res);
    }
}
