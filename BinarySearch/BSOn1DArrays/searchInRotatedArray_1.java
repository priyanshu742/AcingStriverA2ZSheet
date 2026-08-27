package BinarySearch.BSOn1DArrays;

/*

Given an integer array nums, sorted in ascending order (with distinct values) and a target value k.
The array is rotated at some pivot point that is unknown.
Find the index at which k is present and if k is not present return -1.

Example 1
Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0
Output: 4
Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2
Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3
Output: -1
Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.


Constraints
1 <= nums.length <= 104
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= k <= 104

EASY
*/

class Solution 
{
    public int search(int[] nums, int k) 
    {
        int low=0;
        int high=nums.length-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==k)
            {
                return mid;
            }
            else if(nums[low]<=nums[mid])
            {
                if(nums[low]<=k && k<=nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(nums[mid]<=k && k<=nums[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
