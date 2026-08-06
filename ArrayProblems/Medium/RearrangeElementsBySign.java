package ArrayProblems.Medium;

/* 

Given an integer array nums of even length consisting of an equal number of positive and negative integers.
Return the answer array in such a way that the given conditions are met:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.

Example 1
Input : nums = [2, 4, 5, -1, -3, -4]
Output : [2, -1, 4, -3, 5, -4]
Explanation:
The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions

Example 2
Input : nums = [1, -1, -3, -4, 2, 3]
Output : [1, -1, 2, -3, 3, -4]
Explanation:
The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions

Constraints
2 <= nums.length <= 105
1 <= | nums[i] | <= 104
nums.length is an even number.
Number of positive and negative numbers are equal.

EASY
*/

class Solution 
{
    public int[] rearrangeArray(int[] nums) 
    {
        // OPTIMAL 
        int posIndex=0;
        int negIndex=1;

        int ans[]=new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                ans[posIndex]=nums[i];
                posIndex+=2;
            }
            else
            {
                ans[negIndex]=nums[i];
                negIndex+=2;
            }
        }
        return ans;
    }
}


//FOR ODD ARRAY SIZE

class Solution 
{
    public int[] rearrangeArray(int[] nums) 
    {
        // BRUTE

        int positive=0;
        int negative=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                positive++;
            }
            else
            {
                negative++;
            }
        }

        int pos[]=new int[positive];
        int neg[]=new int[negative];
        int posIndex=0;
        int negIndex=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                pos[posIndex]=nums[i];
                posIndex++;
            }
            else
            {
                neg[negIndex]=nums[i];
                negIndex++;
            }
        }
        posIndex=0;
        negIndex=0;

        if(pos.length>neg.length)
        {
            int index=2*neg.length;
            for(int i=0;i<neg.length;i++)
            {
                nums[2*i]=pos[posIndex];
                nums[(2*i)+1]=neg[negIndex];
                posIndex++;
                negIndex++;
            }
            for(int i=neg.length;i<pos.length;i++)
            {
                nums[index]=pos[posIndex];
                index++;
                posIndex++;
            }
        }
        else
        {
            int index=2*pos.length;
            for(int i=0;i<pos.length;i++)
            {
                nums[2*i]=pos[posIndex];
                nums[(2*i)+1]=neg[negIndex];
                posIndex++;
                negIndex++;
            }
            for(int i=pos.length;i<neg.length;i++)
            {
                nums[index]=neg[negIndex];
                index++;
                negIndex++;
            }
        }
        return nums;
    }
}
