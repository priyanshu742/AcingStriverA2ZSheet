package ArrayProblems.Medium;

/*

Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1
Input: nums = [2, 3, 5, -2, 7, -4]
Output: 15
Explanation:
The subarray from index 0 to index 4 has the largest sum = 15

Example 2
Input: nums = [-2, -3, -7, -2, -10, -4]
Output: -2
Explanation:
The element on index 0 or index 3 make up the largest sum when taken as a subarray

Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104

EASY
*/


class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        //KADANE'S ALGORITHM (OPTIMAL)

        int maxi=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum>maxi)
            {
                maxi=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        } 
        return maxi;       
    }
}
