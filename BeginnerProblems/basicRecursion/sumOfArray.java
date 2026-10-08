package BeginnerProblems.basicRecursion;

/*

Given an array nums, find the sum of elements of array using recursion.

Example 1:
Input : nums = [1, 2, 3]
Output : 6
Explanation : The sum of elements of array is 1 + 2 + 3 => 6.

Example 2:
Input : nums = [5, 8, 1]
Output : 14
Explanation : The sum of elements of array is 5 + 8 + 1 => 14.


Constraints:
1 <= n <= 100
0 <= nums[i] <= 100

EASY
*/

class Solution 
{
    public int arraySum(int[] nums) 
    {
        return sum(nums,0);
    }
    public int sum(int nums[],int i)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        return nums[i]+sum(nums,i+1);
    }
}

class Solution2 
{
    public int arraySum(int[] nums) 
    {
        return sum(nums,nums.length-1);
    }
    public int sum(int []nums,int index)
    {
        if(index<0)
        {
            return 0;
        }
        return nums[index]+sum(nums,index-1);
    }
}