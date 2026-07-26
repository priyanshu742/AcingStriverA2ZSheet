package ArrayProblems.Easy;


/*
 
Given an array of integers nums, return the value of the largest element in the array

Example 1
Input: nums = [3, 3, 6, 1]
Output: 6
Explanation: The largest element in array is 6

Example 2
Input: nums = [3, 3, 0, 99, -40]
Output: 99
Explanation: The largest element in array is 99


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums may contain duplicate elements.

EASY
*/

class Solution 
{
    public int largestElement(int[] nums) 
    {
        int large=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>large)
            {
                large=nums[i];
            }
        }
        return large;
    }
}

    

