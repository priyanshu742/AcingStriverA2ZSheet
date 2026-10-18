

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*

Given an integer array nums and an integer target. Return all quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
a, b, c, d are all distinct valid indices of nums.
nums[a] + nums[b] + nums[c] + nums[d] == target.

Notice that the solution set must not contain duplicate quadruplets. One element can be a part of multiple quadruplets. 
The output and the quadruplets can be returned in any order.

Example 1
Input: nums = [1, -2, 3, 5, 7, 9], target = 7
Output: [[-2, 1, 3, 5]]
Explanation:
nums[1] + nums[0] + nums[2] + nums[3] = 7

Example 2
Input: nums = [7, -7, 1, 2, 14, 3], target = 9
Output: []
Explanation:
No quadruplets are present which add upto 9


Constraints
1 <= nums.length <= 200
-104 <= nums[i] <= 104
-104 <= target <= 104

EASY
*/

class Solution1
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        // brute
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    for(int l=k+1;l<nums.length;l++)
                    {
                        int sum=nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum==target)
                        {
                            List<Integer> temp=new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}

class Solution2
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        // better
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                Set<Integer> hash=new HashSet<>();
                for(int k=j+1;k<nums.length;k++)
                {
                    int fourth=target-(nums[i]+nums[j]+nums[k]);
                    if(hash.contains(fourth))
                    {
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(fourth);
                        Collections.sort(temp);
                        result.add(temp);
                    }
                    hash.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}

class Solution3
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        // optimal
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            for(int j=i+1;j<nums.length;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                {
                    continue;
                }
                int low=j+1;
                int high=nums.length-1;
                while(low<high)
                {
                    int sum=nums[i]+nums[j]+nums[low]+nums[high];
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
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        result.add(temp);
                        low++;
                        high--;
                        while(low<high && nums[low]==nums[low-1])
                        {
                            low++;
                        }
                        while(low<high && nums[high]==nums[high+1])
                        {
                            high--;
                        }
                    }
                }
            } 
        }
        return result;
    }
}