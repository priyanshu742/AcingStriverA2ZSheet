package BinarySearch.BSOn1DArrays;

/*

Given a sorted array of nums consisting of distinct integers and a target value,
return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Example 1
Input: nums = [1, 3, 5, 6], target = 5
Output: 2
Explanation: The target value 5 is found at index 2 in the sorted array. Hence, the function returns 2.

Example 2
Input: nums = [1, 3, 5, 6], target = 2
Output: 1
Explanation: The target value 2 is not found in the array. However, it should be inserted at index 1 to maintain the sorted order of the array.


Constraints
1 <= nums.length <= 105
-105 <= nums[i] <= 105
nums contains distinct values sorted in ascending order.
-105<= target <= 105

EASY
*/

class Solution 
{
    public int searchInsert(int[] nums, int target) 
    {
        int low=0;
        int high=nums.length-1;
        int ans=nums.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=target)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}
