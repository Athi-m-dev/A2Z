/* 
 * leetcode  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * keypoints 
 * find the sorted half if left half was sorted then nums[low] is minimum in that sorted area then move the low = mid + 1;
 * if right was sorted store the mid as mininmum and move the high = mid - 1;
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0 , high = n - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            // If duplicates make it ambiguous
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                ans = Math.min(ans, nums[low]);
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }
            else {
                ans = Math.min(ans,nums[mid]);
                high = mid - 1; 
            }
        }
        return ans;
    }
}
