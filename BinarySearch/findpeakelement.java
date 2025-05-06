public class findpeakelement {
    /*
     * linear search for peak element;
     * key points 
     * for linear search if i == 0 we no need check the previos one because it is -1 it give out of bound for this purpose we give this condition 
     * (i == 0 || nums[i - 1] < nums[i]) at i == 0 no need to check the previous one check only the after one for this condition we give 
     * (i == n - 1 || nums[i] > nums[i + 1]))
     * same as last position we no need to check the after one if i == n -1 it skip this condition nums[i] > nums[i + 1]) check only this nums[i - 1] < nums[i]
     * unless other elements it check usually 
     * 
     * 
     * class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
          if ((i == 0 || nums[i - 1] < nums[i])
                && (i == n - 1 || nums[i] > nums[i + 1])) {
            return i;
        }
    }
    return -1;
    }
}
     */



     // binary Search
     //keypoints
     /*
      * if we found the mid the peak will be left half or right half for identify that we use 
       if (nums[mid] > nums[mid - 1]) {
                    low = mid + 1; this is my peak element is in right half
                    if not in right we not to check is it in left half if not in right then it will be in left
                    so fot the condition
                    high = mid - 1;           
      */
      //leetcode https://leetcode.com/problems/find-peak-element/

        public int findPeakElement(int[] nums) {
            int n = nums.length;
            if (n == 1) return 0;
            if (nums[0] > nums[1]) return 0;
            if (nums[n - 1] > nums[n - 2]) return n - 1;
            int low = 1, high = n - 2;
    
            while (low <= high) {
                int mid = (low + high) / 2;
    
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
    
                if (nums[mid] > nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    // no need to check nums[mid] > nums[mid+1] because for multiple peaks it go to infinite loop
                    //for example nums[] = {1,5,1,2,1} mid = 1 where 1 > 5 and 1 > 2 it go infinite 
                    //simply give high = mid - 1 if not in right half
                    high = mid - 1;
                }
            }
            // return dummy statement
            return -1;
        }
    
        public static void main(String[] args) {
            int[] nums = {1, 2, 1, 3, 5, 6, 4}; // Initialize the 1D array
            findpeakelement obj = new findpeakelement();
            int peakIndex = obj.findPeakElement(nums);
            System.out.println("The peak element is at index: " + peakIndex);
        }
    }
