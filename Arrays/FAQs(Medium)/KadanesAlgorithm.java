
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

class Solution1 
{
    public int maxSubArray(int[] nums) 
    {
        // brute;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum+=nums[j];
                if(sum>largest)
                {
                    largest=sum;
                }
            }
        }
        return largest;
    }
}

class Solution2 
{
    public int maxSubArray(int[] nums) 
    {
        // optimal;
        // Kadane's-Algorithm;
        int largest=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum>largest)
            {
                largest=sum;
            }
            if(sum<0)
            {
                sum=0;
            }            
        }
        return largest;
    }
}

class Solution3
{
    public int maxSubArray(int[] nums) 
    {
        // optimal
        // Kadane's-Algorithm
        // to print the Subarray
        int largest=Integer.MIN_VALUE;
        int sum=0;
        int ansStart=-1;
        int ansEnd=-1;
        int start=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(sum==0)
            {
                start=i;
            }
            sum=sum+nums[i];
            if(sum>largest)
            {
                largest=sum;
                ansStart=start;
                ansEnd=i;
            }
            if(sum<0)
            {
                start=i+1;
                sum=0;
            }            
        }
        return largest;
    }
}