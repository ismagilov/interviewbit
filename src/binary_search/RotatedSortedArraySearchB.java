package binary_search;

/**
 * Find min, split, search in left and right parts
 *
 * https://www.interviewbit.com/problems/rotated-sorted-array-search/
 */
 public class RotatedSortedArraySearchB {
    //1, 2, 3, 4, 5 --> 4, 5, 1, 2, 3
    public int findInRotated(int[] arr, int x) {
        int min = findMin(arr);

        int res = classicBinarySearch(arr, min, arr.length - 1, x);
        if (res == -1)
            return classicBinarySearch(arr, 0, min - 1, x);
        else
            return res;
    }

    private int findMin(int[] arr) {
        int b = 0, e = arr.length - 1;

        if (arr[b] <= arr[e])
            return b;

        while (b <= e) {
            int mid = b + (e - b) / 2;

            if (mid == 0 || arr[mid] < arr[mid - 1])
                return mid;
            else if (arr[mid] > arr[0])
                b = mid + 1;
            else if (arr[mid] < arr[0])
                e = mid - 1;
        }

        return -1;
    }

    private int classicBinarySearch(int[] arr, int b, int e, int x) {
        while (b <= e) {
            int mid = b + (e - b) / 2;

            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                e = mid - 1;
            else if (arr[mid] < x)
                b = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArraySearchB s = new RotatedSortedArraySearchB();

        System.out.println(s.findInRotated(new int[] {3, 1, 2}, 2)); // 2
        System.out.println(s.findInRotated(new int[] {3, 1, 2}, 3)); // 0
        System.out.println(s.findInRotated(new int[] {3, 1, 2}, 1)); // 1

        System.out.println(s.findInRotated(new int[] {4, 1, 2, 3}, 4)); // 0
        System.out.println(s.findInRotated(new int[] {1, 2, 3, 4}, 1)); // 0
        System.out.println(s.findInRotated(new int[] {1, 2, 3, 4}, 3)); // 2
        System.out.println(s.findInRotated(new int[] {1, 2, 3, 4}, 4)); // 3
    }
}
