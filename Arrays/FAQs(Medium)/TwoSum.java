
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 

Given an array of integers nums and an integer target. 
Return the indices(0 - indexed) of two elements in nums such that they add up to target.
Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in any order.

Example 1
Input: nums = [1, 6, 2, 10, 3], target = 7
Output: [0, 1]
Explanation:
nums[0] + nums[1] = 1 + 6 = 7

Example 2
Input: nums = [1, 3, 5, -7, 6, -3], target = 0
Output: [1, 5]
Explanation:
nums[1] + nums[5] = 3 + (-3) = 0


Constraints
2 <= nums.length <= 105
-104 <= nums[i] <= 104
-105 <= target <= 105
Only one valid answer exists.

EASY
*/

class Solution1 
{
    public int[] twoSum(int[] nums, int target) 
    {
        // brute
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(i==j)
                {
                    continue;
                }
                if(nums[i]+nums[j]==target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{}; // dummy return;
    }
}

class Solution2 
{
    public int[] twoSum(int[] nums, int target) 
    {
        // brute
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{}; // dummy return;
    }
}

class Solution3 
{
    public int[] twoSum(int[] nums, int target) 
    {
        // optimal
        Map<Integer,Integer> record=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int prefix=target-nums[i];
            if(record.containsKey(prefix))
            {
                return new int[]{i,record.get(prefix)};
            }
            record.put(nums[i],i);
        }
        return new int[]{}; // dummy return; 
    }
}

class Solution4
{
    public int[] twoSum(int[] nums, int target) 
    {
        // optimal for returning YES or NO
        Arrays.sort(nums);
        int low=0;
        int high=nums.length-1;
        while(low<high)
        {
            int sum=nums[low]+nums[high];
            if(sum<target)
            {
                low++;
            }
            else if(sum>target)
            {
                high--;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}