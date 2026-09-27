package BeginnerProblems.basicRecursion;


/*

Given an array nums of n integers, return reverse of the array.

Example 1:
Input : nums = [1, 2, 3, 4, 5]
Output : [5, 4, 3, 2, 1]

Example 2:
Input : nums = [1, 3, 3, 3, 5]
Output : [5, 3, 3, 3, 1]


Constraints:
1 <= n <= 100
1 <= nums[i] <= 100

EASY
*/


class Solution 
{
    public int[] reverseArray(int[] nums) 
    {
        return reverse(nums,0,nums.length-1);
    }
    public int[] reverse(int[] nums,int low,int high)
    {
        if(low>=high)
        {
            return nums;
        }
        int temp=nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
        
        return reverse(nums,low+1,high-1);
    } 
}


    

