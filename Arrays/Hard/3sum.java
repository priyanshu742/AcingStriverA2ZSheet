package ArrayProblems.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 

Given an integer array nums. Return all triplets such that:
i != j, i != k, and j != k
nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets. One element can be a part of multiple triplets. 
The output and the triplets can be returned in any order.

Example 1
Input: nums = [2, -2, 0, 3, -3, 5]
Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]
Explanation:
nums[1] + nums[2] + nums[0] = 0
nums[4] + nums[1] + nums[5] = 0
nums[4] + nums[2] + nums[3] = 0

Example 2
Input: nums = [2, -1, -1, 3, -1]
Output: [[-1, -1, 2]]
Explanation:
nums[1] + nums[2] + nums[0] = 0
Note that we have used two -1s as they are separate elements with different indexes
But we have not used the -1 at index 4 as that would create a duplicate triplet


Constraints
1 <= nums.length <= 3000
-104 <= nums[i] <= 104

EASY
*/

class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        // Optimal
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0)
                {
                    j++;
                }
                else if(sum>0)
                {
                    k--;
                }
                else
                {
                    List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])
                    {
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1])
                    {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}