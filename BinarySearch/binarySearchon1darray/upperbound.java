public class upperbound {
    public static int upper (int arr[] , int n , int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {3 , 4 , 5 , 7, 8 , 9};
        int x = 7;
        int n = 6;
        int smallindex = upper(arr, n, x);
        System.out.println("The smallest index is " + smallindex);
    }
}
