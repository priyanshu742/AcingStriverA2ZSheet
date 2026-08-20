package ArrayProblems.Hard;

/*

Given an integer array nums. Find the subarray with the largest product, 
and return the product of the elements present in that subarray.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1
Input: nums = [4, 5, 3, 7, 1, 2]
Output: 840
Explanation:
The largest product is given by the whole array itself

Example 2
Input: nums = [-5, 0, -2]
Output: 0
Explanation:
The largest product is achieved with the following subarrays [0], [-5, 0], [0, -2], [-5, 0, -2].


Constraints
1 <= nums.length <= 104
-10 <= nums[i] <= 10
-109 <= product of any prefix or suffix of nums <= 109

EASY
*/

class Solution
{
    public int maxProduct(int[] nums) 
    {
        // optimal intuitive
        int size=nums.length;
        int maximum=Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        for(int i=0;i<size;i++)
        {
            if(prefix==0)
            {
                prefix=1;
            }
            if(suffix==0)
            {
                suffix=1;
            }
            prefix=prefix*nums[i];
            suffix=suffix*nums[size-i-1];
            maximum=Math.max(maximum,Math.max(prefix,suffix));
        }
        return maximum;
    }
}
