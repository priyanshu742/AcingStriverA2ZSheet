package ArrayProblems.Easy;


/*

Given an integer array nums, rotate the array to the left by one.
Note: There is no need to return anything, just modify the given array.


Example 1
Input: nums = [1, 2, 3, 4, 5]
Output: [2, 3, 4, 5, 1]
Explanation:
Initially, nums = [1, 2, 3, 4, 5]
Rotating once to left -> nums = [2, 3, 4, 5, 1]

Example 2
Input: nums = [-1, 0, 3, 6]
Output: [0, 3, 6, -1]
Explanation:
Initially, nums = [-1, 0, 3, 6]
Rotating once to left -> nums = [0, 3, 6, -1]


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104

EASY
*/

class Solution 
{
    public void rotateArrayByOne(int[] nums)
    {
        int first=nums[0];
        for(int i=0;i<nums.length-1;i++)
        {
            nums[i]=nums[i+1];
        }
        nums[nums.length-1]=first;
    }
}
