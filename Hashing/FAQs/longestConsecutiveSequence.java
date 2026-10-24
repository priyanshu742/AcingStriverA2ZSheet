package Hashing.FAQs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*

Given an array nums of n integers.
Return the length of the longest sequence of consecutive integers. 
The integers in this sequence can appear in any order.

Example 1:
Input: nums = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation:
The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. 
This sequence can be formed regardless of the initial order of the elements in the array.

Example 2:
Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
Output: 9
Explanation:
The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9. 


Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109

MEDIUM
*/

class Solution1
{
    public int longestConsecutive(int[] nums) 
    {
        // better
        int count=1;
        int longest=1;
        Set<Integer> numSet=new TreeSet<>();
        for(int n : nums)
        {
            numSet.add(n);
        }
        for(int n : numSet)
        {
            int current=n;
            if(numSet.contains(current+1))
            {
                current=current+1;
                count++;
                if(count>longest)
                {
                    longest=count;
                }
            }
            else
            {
                count=1;
            }
        }
        return longest;
    }
}

class Solution2
{
    // brute
    public int longestConsecutive(int[] nums) 
    {
        int longest=1;
        for(int i=0;i<nums.length;i++)
        {
            int count=1;
            int x=nums[i];
            while(linearSearch(nums,x+1)==true)
            {
                x=x+1;
                count++;
                if(count>longest)
                {
                    longest=count;
                }
            }
        }
        return longest;
    }
    public boolean linearSearch(int[] nums,int target)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                return true;
            }
        }
        return false;
    } 
}

class Solution3 
{
    public int longestConsecutive(int[] nums) 
    {
        // better
        Arrays.sort(nums);
        int lastSmallest=Integer.MIN_VALUE;
        int count=0;
        int largest=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-1==lastSmallest)
            {
                count++;
                if(count>largest)
                {
                    largest=count;
                }
                lastSmallest=nums[i];
            }
            else if(lastSmallest!=nums[i])
            {
                count=1;
                lastSmallest=nums[i];
            }
            
        }
        return largest;
    }
}

class Solution4 
{
    public int longestConsecutive(int[] nums) 
    {
        // optimal
        int longest=0;
        Set<Integer> numSet=new HashSet<>();
        for(int n : nums)
        {
            numSet.add(n);
        }
        for(int n : numSet)
        {
            if(!numSet.contains(n-1))
            {
                int current=n;
                int count=1;
                while(numSet.contains(current+1))
                {
                    count++;
                    current=current+1;
                }
                if(count>longest)
                {
                    longest=count;
                }
            }
        }
        return longest;
    }
}