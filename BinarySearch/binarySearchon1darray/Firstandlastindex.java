/* leetcode https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ 
*/
public class Firstandlastindex {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);
        if (first == -1)  return new int[] {-1,-1};
        int second = findSecond(nums,target);
        int count = (first == -1) ? 0 : (second - first + 1);
        System.out.println("The Count Of The Target " + count);
        return new int[] {first,second};
    }

    static int findFirst (int nums[] , int target) {
        int n = nums.length;
        int low = 0 , high = n -1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            }    
            else if (nums[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return first;
    }

    static int findSecond (int nums[] , int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int second = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                second = mid;
                low = mid + 1;
            }
            else if (nums[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
            
        }
        return second;
    }
}
