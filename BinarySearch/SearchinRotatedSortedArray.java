//leetcode
//https://leetcode.com/problems/search-in-rotated-sorted-array/

/* 
 * key points identify the sorted area and check the our target is between that area
 */

 /* 
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
*/
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //left sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            else {
                //right sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }  
}

/* for binary search
Time Complexity: O(logN), where N = size of the given array.
Reason: We are basically using the Binary Search algorithm.
Space Complexity: O(1) as we are using no extra space.
*/