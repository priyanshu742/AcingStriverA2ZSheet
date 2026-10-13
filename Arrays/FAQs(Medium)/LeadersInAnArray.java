

import java.util.ArrayList;
import java.util.List;

/* 

Given an integer array nums, return a list of all the leaders in the array.
A leader in an array is an element whose value is strictly greater than all elements to its right in the given array.
The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.

Example 1
Input: nums = [1, 2, 5, 3, 1, 2]
Output: [5, 3, 2]
Explanation:
2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

Example 2
Input: nums = [-3, 4, 5, 1, -4, -5]
Output: [5, 1, -4, -5]
Explanation:
-5 is the rightmost element, -4 is the largest element in the index range [4, 5], 1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104

EASY
*/

class Solution1 
{
    public List<Integer> leaders(int[] nums) 
    {
        // brute
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int flag=1;
            int leader=nums[i];
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]>leader)
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                result.add(leader);
            }
        }   
        return result;     
    }
}

class Solution2 
{
    public List<Integer> leaders(int[] nums) 
    {
        // optimal
        List<Integer> result=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]>max)
            {
                result.add(nums[i]);
                max=nums[i];
            }
        }
        int low=0;
        int high=result.size()-1;
        while(low<high)
        {
            int temp=result.get(low);
            result.set(low,result.get(high));
            result.set(high,temp);
            low++;
            high--;
        }
        return result; 
    }
}