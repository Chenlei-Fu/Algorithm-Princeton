public class bitonicSearch{
    public static int descendingBinarySearch(int[] array, int left, int right, int value){
        System.out.println("Descending Binary Search");
        if(left >= right) return -1;
        int mid = left + (right - left)/2;
        if(array[mid] == value){
            System.out.println("value found");
            return mid;
        }
        if(left+1 == right){
            return -1; // interval is not splittable.
        }
        if(value < array[mid]){
            return descendingBinarySearch(array, mid+1, right, value);
        }else{
            return descendingBinarySearch(array, left, mid, value);
        }
    }

    public static int ascendingBinarySearch(int[] array, int left, int right, int value){
        System.out.println("Ascending Binary Search");
        if(left >= right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if(array[mid] == value){
            System.out.println("value found");
            return mid;
        }
        if(left + 1 == right){
            return -1;
        }
        if(value > array[mid]){
            return ascendingBinarySearch(array, mid+1, right, value);
        } else{
            return ascendingBinarySearch(array, left, mid, value);
        }
    }
    public static int bitonic_search(int[] array, int left, int right, int value) {
        System.out.println("Bitonic Search");
        if (left == right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == value) {
            System.out.println("value found!");
            return mid;
        }
        if (left + 1 == right) {
            return -1;
        }

        if (array[mid] > array[mid - 1]) {
            if (value > array[mid]) {
                return bitonic_search(array, mid + 1, right, value);
            } else {
                
                int a = ascendingBinarySearch(array, left, mid, value);
                int d = descendingBinarySearch(array, mid + 1, right, value);
                return (a == -1? d:a);
            }
        } else {
            if (value > array[mid]) {
                return bitonic_search(array, left, mid, value);
            } else {
                int a = ascendingBinarySearch(array, left, mid, value);
                int d = descendingBinarySearch(array, mid + 1, right, value);
                return (a == -1? d: a);
            }
        }
        
    }

    public static void main(String[] args) {
        int array[] = { 2, 3, 5, 7, 9, 11, 13, 4, 1, 0 };
        int value = 4, left = 0, right = 10;
        int res = bitonic_search(array, left, right, value);
        System.out.println(res);
    }
}