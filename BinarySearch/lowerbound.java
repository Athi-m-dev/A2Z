// Problem Statement:
// You are given a sorted array of integers in ascending order, and an integer x. Your task is to write a Java program that finds the index of the smallest element in the array that is greater than or equal to x (this is known as the upper bound of x).

// If all elements in the array are less than x, return the length of the array.

// Use binary search to implement the solution efficiently.
// Input:
//     An integer x, the value for which the upper bound is to be found.
// Note: The array is fixed in the code as {3, 5, 8, 15, 19}.
// Output:
//     Print the index of the smallest element in the array which is greater than or equal to x, in the format:

import java.util.Scanner;
public class lowerbound {    
    // approach binary search
    public static int checkbound (int arr[],int n,int x) {
        int low = 0 , high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + high / 2;

            if (arr[mid] >= x) {
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
        Scanner obj = new Scanner(System.in);
        int x = obj.nextInt();     

        int arr[] = {3, 5, 8, 15, 19};
        int n = 5;
        int index = checkbound(arr,n,x);
        System.out.println("The lowest index of the upper bound is " + index);
    }
}


// public class lowerbound {   
//     // approach linear search
//     public static int lowerBound(int []arr, int n, int x) {
//         for (int i = 0; i < n; i++) {
//             if (arr[i] >= x) {
//                 // lower bound found:
//                 return i;
//             }
//         }
//         return n;
//     }

//     public static void main(String[] args) {
//         int[] arr = {3, 5, 8, 15, 19};
//         int n = 5, x = 9;
//         int ind = lowerBound(arr, n, x);
//         System.out.println("The lower bound is the index: " + ind);
//     }
// }


/* for binary search
Time Complexity: O(logN), where N = size of the given array.
Reason: We are basically using the Binary Search algorithm.
Space Complexity: O(1) as we are using no extra space.
*/

/* for linear search the time compicity is 
Time Complexity: O(N), where N = size of the given array.
 Reason: In the worst case, we have to travel the whole array. This is basically the time complexity of the linear search algorithm.
Space Complexity: O(1) as we are using no extra space. */

