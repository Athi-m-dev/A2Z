/* 
 * keypoints 
 * Check if arr[low] = arr[mid] = arr[high]: If this condition is satisfied, we will just increment the low pointer and decrement the high pointer by one step. We will not perform the later steps until this condition is no longer satisfied. So, we will continue to the next iteration from this step
 * because if low == mid == high give problem to identify the sorted area 
 *  so we need to differentiate
 * */


public class SearchinRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0 , high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return true;
            }  
            // this is important to understand 
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            // if left statisfied 
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                   low = mid + 1;
                }
            }
            //if left not automatically right no need to check nums[mid] <= nums[high] because definetly there is one sorted area will there
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
