
import java.util.ArrayList;
import java.util.List;

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

class Solution1 
{
    public int[] rearrangeArray(int[] nums) 
    {
        // optimal
        int result[]=new int[nums.length];
        int positive=0;
        int negative=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result[positive]=nums[i];
                positive+=2; 
            }
            else
            {
                result[negative]=nums[i];
                negative+=2;
            }
        }
        return result;
    }
}

class Solution2
{
    public int[] rearrangeArray(int[] nums) 
    {
        // brute
        int n=nums.length;
        int result[]=new int[n];
        List<Integer> positive=new ArrayList<>();
        List<Integer> negative=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                positive.add(nums[i]);
            }
            else
            {
                negative.add(nums[i]);
            }
        }
        for(int i=0;i<n/2;i++)
        {
            result[2*i]=positive.get(i);
            result[2*i+1]=negative.get(i);
        }
        return result;  
    }
}

class Solution3
{
    public int[] rearrangeArray(int[] nums) 
    {
        // if positive and negative elements are not equal then
        int n=nums.length;
        int result[]=new int[n];
        List<Integer> positive=new ArrayList<>();
        List<Integer> negative=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                positive.add(nums[i]);
            }
            else
            {
                negative.add(nums[i]);
            }
        }
        if(positive.size()>negative.size())
        {
            for(int i=0;i<n/2;i++)
            {
                result[2*i]=positive.get(i);
                result[2*i+1]=negative.get(i);
            }
            int index=negative.size()*2;
            for(int i=negative.size();i<positive.size();i++)
            {
                result[index]=positive.get(i);
                index++;
            }
        }
        else
        {
            for(int i=0;i<n/2;i++)
            {
                result[2*i]=positive.get(i);
                result[2*i+1]=negative.get(i);
            }
            int index=positive.size()*2;
            for(int i=positive.size();i<negative.size();i++)
            {
                result[index]=negative.get(i);
                index++;
            }
        }
        return result;  
    }
}