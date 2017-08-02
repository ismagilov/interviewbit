package binary_search;

public class SearchFirstOrLastOccurence {
    public static int searchFirst(int[] arr, int x) {
        int b = 0, e = arr.length - 1;

        int res = -1;
        while (b <= e) {
            int mid = b + (e - b) / 2;

            if (arr[mid] == x) {
                res = mid;
                e = mid - 1;
            } else if (arr[mid] > x) {
                e = mid - 1;
            } else {
                b  = mid + 1;
            }
        }

        return res;
    }

    public static int searchLast(int[] arr, int x) {
        int b = 0, e = arr.length - 1;

        int res = -1;
        while (b <= e) {
            int mid = b + (e - b) / 2;

            if (arr[mid] == x) {
                res = mid;
                b = mid + 1;
            } else if (arr[mid] > x) {
                e = mid - 1;
            } else if (arr[mid] < x){
                b  = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 9, 9, 9, 13, 17, 21, 24};

        System.out.println(searchFirst(arr, 9)); // 3
        System.out.println(searchFirst(arr, 15)); // -1

        System.out.println(searchLast(arr, 9)); // 5
        System.out.println(searchLast(arr, 15)); // -1
        System.out.println(searchLast(arr, 5)); // 1
    }
}
