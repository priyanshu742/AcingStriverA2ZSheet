package ArrayProblems.Easy;


/*

Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same.
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

class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        // OPTIMAL SOLUTION
        int j=-1;
        for(int k=0;k<nums.length;k++)
        {
            if(nums[k]==0)
            {
                j=k;
                break;
            }
        }
        if(j==-1)
        {
            return;
        }

        for(int i=j+1;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
        }
    }
}
