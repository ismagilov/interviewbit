package binary_search;

/**
 * Compare with mid with prev: arr[mid] < a[prev]
 *
 * https://www.interviewbit.com/problems/rotated-array/
 */
public class FindMinInRotatedArrayB {
    public int findMin(int[] a) {
        int lng = a.length;
        int b = 0, e = lng - 1;

        if (a[b] < a[e])
            return b;

        while (b <= e) {
            int mid = b + (e - b) / 2;

            if (mid == 0 || a[mid] < a[mid - 1])
                return mid;
            else if (a[mid] > a[0])
                b = mid + 1;
            else if (a[mid] < a[0])
                e = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMinInRotatedArrayB s = new FindMinInRotatedArrayB();

        System.out.println(s.findMin(new int[] {2, 3, 4, 1})); // 3
        System.out.println(s.findMin(new int[] {3, 4, 1, 2})); // 2
        System.out.println(s.findMin(new int[] {4, 1, 2, 3})); // 1

        System.out.println(s.findMin(new int[] {1, 2, 3})); // 0
        System.out.println(s.findMin(new int[] {2, 3, 1})); // 2
        System.out.println(s.findMin(new int[] {3, 1, 2})); // 1
    }

}
