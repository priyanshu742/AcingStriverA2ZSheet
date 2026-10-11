package Arrays.LogicBuilding;

/*

Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), 
return the only number missing from the array within this range.

Example 1
Input: nums = [0, 2, 3, 1, 4]
Output: 5
Explanation:
nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]

Example 2
Input: nums = [0, 1, 2, 4, 5, 6]
Output: 3
Explanation:
nums contains 0, 1, 2, 4, 5, 6 thus leaving 3 as the only missing number in the range [0, 6]


Constraints
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.

EASY
*/

class Solution1 
{
    public int missingNumber(int[] nums) 
    {
        // brute
       for(int i=0;i<=nums.length;i++)
       {
            int flag=0;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[j]==i)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                return i;
            }
       } 
        return -1;
    }
}

class Solution2 
{
    public int missingNumber(int[] nums) 
    {
        // better
        int hash[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            hash[nums[i]]++;
        }
        for(int i=0;i<hash.length;i++)
        {
            if(hash[i]==0)
            {
                return i;
            }
        }
        return -1;
    }
}
class Solution3 
{
    public int missingNumber(int[] nums) 
    {
        // optimal (A)
        int n=nums.length;
        int expectedSum=n*(n+1)/2;
        int actualSum=0;
        for(int ele : nums)
        {
            actualSum+=ele;
        }
        return expectedSum-actualSum; 
    }
}

class Solution4
{
    public int missingNumber(int[] nums) 
    {
        // optimal (B)
        int xor1=0;
        int xor2=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            xor2=xor2^nums[i];
            xor1=xor1^(i+1);
        }
        return xor1^xor2;  
    }
}