package BinarySearch.BSOn1DArrays;

/*

Given an array nums sorted in non-decreasing order. 
Every number in the array except one appears twice.
Find the single number in the array.

Example 1
Input :nums = [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
Output:4
Explanation: Only the number 4 appears once in the array.

Example 2
Input : nums = [1, 1, 3, 5, 5]
Output:3
Explanation: Only the number 3 appears once in the array.


Constraints
n == nums.length
1 <= n <= 104
-104 <= nums[i] <= 104

MEDIUM
*/

class Solution 
{
    public int singleNonDuplicate(int[] nums) 
    {
        int low=1;
        int high=nums.length-2;

        // edge cases
        if(nums.length==1)
        {
            return nums[0];
        }

        if(nums[0]!=nums[1])
        {
            return nums[0];
        }

        if(nums[nums.length-1]!=nums[nums.length-2])
        {
            return nums[nums.length-1];
        }

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])
            {
                return nums[mid];
            }
            // we are in left (even,odd)
            if( ( mid % 2==1 && nums[mid]==nums[mid-1] ) || ( mid % 2==0 && nums[mid]==nums[mid+1]))
            {
                low=mid+1;
            }
            // we are in right (odd,even)
            else if(( mid % 2 ==0 && nums[mid]==nums[mid-1]) || (mid % 2==1 && nums[mid]==nums[mid+1]) )
            {
                high=mid-1;
            }
        }
        return -1;
    }
}