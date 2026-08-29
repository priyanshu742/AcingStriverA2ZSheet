package BinarySearch.BSOn1DArrays;

import java.util.ArrayList;

/*

Given an integer array nums of size N, sorted in ascending order with distinct values,and then rotated an unknown number of times (between 1 and N),
find the minimum element in the array.

Example 1
Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
Output: 0
Explanation: Here, the element 0 is the minimum element in the array.

Example 2
Input : nums = [3, 4, 5, 1, 2]
Output: 1
Explanation:Here, the element 1 is the minimum element in the array.


Constraints
n == nums.length
1 <= n <= 104
-104 <= nums[i] <= 104
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.

EASY    
*/

class Solution 
{
    public int findMin(ArrayList<Integer> arr) 
    {
        // SLIGHT OPTIMISATION
        int low=0;
        int high=arr.size()-1;
        int min=Integer.MAX_VALUE;

        while(low<=high)
        {
            /* 
            If the search space is already sorted
            then always arr.get(low) will be smaller
            in the search space 
            */
            if(arr.get(low)<=arr.get(high))
            {
                min=Math.min(min,arr.get(low));
                break;
            }

            int mid=low+(high-low)/2;
            if(arr.get(low)<=arr.get(mid))
            {
                min=Math.min(min,arr.get(low));
                low=mid+1;
            }
            else
            {
                min=Math.min(min,arr.get(mid));
                high=mid-1;
            }
        }
        return min;
    }
}
