package ArrayProblems.Easy;

/*

Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1

Example 1
Input: nums = [2, 3, 4, 5, 3], target = 3
Output: 1
Explanation:
The first occurence of 3 in nums is at index 1

Example 2
Input: nums = [2, -4, 4, 0, 10], target = 6
Output: -1
Explanation:
The value 6 does not occur in the array, hence output is -1


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
-104 <= target <= 104

EASIEST
*/


class Solution 
{
    public int linearSearch(int nums[], int target) 
    {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                return i;
            }
        }
        return -1;
    }
}