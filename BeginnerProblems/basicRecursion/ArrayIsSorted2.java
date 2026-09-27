package BeginnerProblems.basicRecursion;

import java.util.ArrayList;

/*

Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false.

Example 1:
Input : nums = [1, 2, 3, 4, 5]
Output : true
Explanation : For all i (1 <= i <= 4) it holds nums[i] <= nums[i+1], hence it is sorted and we return true.

Example 2:
Input : nums = [1, 2, 1, 4, 5]
Output : false
Explanation : For i == 2 it does not hold nums[i] <= nums[i+1], hence it is not sorted and we return false.


Constraints:
1 <= n <= 100
1 <= nums[i] <= 100

EASY
*/

class Solution1 
{
    public boolean isSorted(ArrayList<Integer> nums) 
    {
        return check(nums,0,nums.size()-1);
    }
    public boolean check(ArrayList<Integer> nums,int index,int high) 
    {
        if(index>high-1)
        {
            return true;
        }
        if(nums.get(index)>nums.get(index+1))
        {
            return false;
        }
        return check(nums,index+1,high);
    }
}

class Solution2
{
    public boolean isSorted(ArrayList<Integer> nums) 
    {
        return check(nums,nums.size()-1);
    }
    public boolean check(ArrayList<Integer> nums,int index) 
    {
        if(index<1)
        {
            return true;
        }
        if(nums.get(index)<nums.get(index-1))
        {
            return false;
        }
        return check(nums,index-1);
    }
}