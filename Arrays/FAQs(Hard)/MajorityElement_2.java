
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Given an integer array nums of size n. 
Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

Example 1
Input: nums = [1, 2, 1, 1, 3, 2]
Output: [1]
Explanation:
Here, n / 3 = 6 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1]

Example 2
Input: nums = [1, 2, 1, 1, 3, 2, 2]
Output: [1, 2]
Explanation:
Here, n / 3 = 7 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1, 2]


Constraints
n == nums.length.
2 <= n <= 105
-104 <= nums[i] <= 104

EASY
*/

class Solution1
{
    public List<Integer> majorityElementTwo(int[] nums) 
    {
        // brute
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(result.size()==0 || result.get(0)!=nums[i])
            {
                int count=0;
                for(int j=0;j<n;j++)
                {
                    if(nums[i]==nums[j])
                    {
                        count++;
                    }
                    if(count>n/3)
                    {
                        result.add(nums[i]); 
                        break;
                    }
                }
            }
            if(result.size()>=2)
            {
                break;
            }
        }
        return result;
    }
}

class Solution2 
{
    public List<Integer> majorityElementTwo(int[] nums) 
    {
        // better
        int n=nums.length;
        Map<Integer,Integer> dict=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int ele : nums)
        {
            dict.put(ele,dict.getOrDefault(ele,0)+1);
            if(dict.get(ele)>n/3)
            {
                if(result.size()==0 || result.get(0)!=ele)
                {
                    result.add(ele);
                }
            }
            if(result.size()>=2)
            {
                break;
            }
        }
        return result;  
    }
}

class Solution3
{
    public List<Integer> majorityElementTwo(int[] nums) 
    {
        // optimal
        int n=nums.length;
        int count1=0;
        int count2=0;
        int major1=Integer.MIN_VALUE;
        int major2=Integer.MIN_VALUE;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(count1==0 && nums[i]!=major2)
            {
                major1=nums[i];
                count1=1;
            }
            else if(count2==0 && nums[i]!=major1)
            {
                major2=nums[i];
                count2=1;
            }
            else if(nums[i]==major1)
            {
                count1++;
            }
            else if(nums[i]==major2)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==major1)
            {
                count1++;
            }
            if(nums[i]==major2)
            {
                count2++;
            }
        }
        if(count1>n/3)
        {
            result.add(major1);
        }
        if(count2>n/3)
        {
            result.add(major2);
        }
        return result;
    }
}