/* the small value index is the times of rotation that array taken
 * int[] nums = {4, 5, 6, 1, 2, 3};
 * for example the index of 1 = 3 the rotation is three
 * and another case the currrent element less than or equal to previous element example we are 1 and 1 < 6 this place the array trogger so three time array rotate
 * 
  for linear search
  for (int i = 1; i < nums.length; i++) {
    if (nums[i] < nums[i - 1]) {
        return i;
    }
}
 * 
 */

public class Findouthowmanytimesarrayhasbeenrotated {
    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }

                // Eliminate left half:
                low = mid + 1;
            } else { //if right part is sorted:

                // keep the minimum:
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findKRotation(arr);
        System.out.println("The array is rotated " + ans + " times.");
    }
}


