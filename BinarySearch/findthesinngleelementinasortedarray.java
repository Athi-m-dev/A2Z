/*keypoints 
 * first we need to indentify we are left side or right side of the array
 * if we are in left side then mid - 1 will be the single element
 * if we are in right side then mid + 1 will be the single element
 *  * if mid is even then we need to check the mid + 1 element if it is same then we are in left side of the array
 * if mid is odd then we need to check the mid - 1 element if it is same then we are in left side of the array
 *  
 */
// leetcode https://leetcode.com/problems/single-element-in-a-sorted-array/
//  * keypoints

import java.util.Arrays;
public class findthesinngleelementinasortedarray {
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            // we are in left half and element in right half
            if (mid % 2 == 1 && nums[mid - 1] == nums[mid] || mid % 2 == 0 && nums[mid + 1] == nums[mid]) {
                low = mid + 1;
            }
            // we are in right half and element in left half
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6}; // Initialize the 1D array
        int ans = singleNonDuplicate(nums);
        System.out.println("The single element is: " + ans);
    }
}