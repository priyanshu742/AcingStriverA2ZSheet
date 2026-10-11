package Arrays.LogicBuilding;

import java.util.ArrayList;
import java.util.List;

/*

Given an integer array nums, move all the 0's to the end of the array. 
The relative order of the other elements must remain the same.
This must be done in place, without making a copy of the array.

Example 1
Input: nums = [0, 1, 4, 0, 5, 2]
Output: [1, 4, 5, 2, 0, 0]
Explanation:
Both the zeroes are moved to the end and the order of the other elements stay the same

Example 2
Input: nums = [0, 0, 0, 1, 3, -2]
Output: [1, 3, -2, 0, 0, 0]
Explanation:
All 3 zeroes are moved to the end and the order of the other elements stay the same


Constraints
1 <= nums.length <= 105
-104 <=nums[i] <= 104

EASY
*/

class Solution1
{
    public void moveZeroes(int[] nums) 
    {
        // brute
        List<Integer> temp=new ArrayList<>();
        for(int n : nums)
        {
            if(n!=0)
            {
                temp.add(n);
            }
        }
        for(int i=0;i<temp.size();i++)
        {
            nums[i]=temp.get(i);
        }
        for(int i=temp.size();i<nums.length;i++)
        {
            nums[i]=0;
        }
    }
}

class Solution2
{
    public void moveZeroes(int[] nums) 
    {
        // slightly optimal
        int index=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[index]=nums[i];
                index++;
            }
        }
        for(int i=index;i<nums.length;i++)
        {
            nums[i]=0;
        }
    }
}

class Solution3
{
    public void moveZeroes(int[] nums) 
    {
        // optimal
        int j=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                j=i; 
                break;
            }
        }
        if(j==-1)
        {
            return ;
        }
        for(int i=j+1;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                swap(nums,i,j);
                j++;
            }
        }
    }
    public void swap(int[] nums,int left,int right)
    {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    } 
}
