import java.util.HashMap;
import java.util.Map;

/* 

Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array,
except for A, which appears twice and B which is missing.
Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
Note: You are not allowed to modify the original array.

Example 1
Input: nums = [3, 5, 4, 1, 1]
Output: [1, 2]
Explanation:
1 appears two times in the array and 2 is missing from nums

Example 2
Input: nums = [1, 2, 3, 6, 7, 5, 7]
Output: [7, 4]
Explanation:
7 appears two times in the array and 4 is missing from nums.


Constraints
n == nums.length
1 <= n <= 105
n - 2 elements in nums appear exactly once and are valued between [1, n].
1 element in nums appears twice, and is valued between [1, n].

MEDIUM
*/

class Solution1
{
    public int[] findMissingRepeatingNumbers(int[] nums) 
    {
        // brute
        int repeated=-1;
        int missing=-1;
        for(int i=1;i<=nums.length;i++)
        {
            int count=0;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[j]==i)
                {
                    count++;
                }
            }
            if(count==0)
            {
                missing=i;
            }
            else if(count==2)
            {
                repeated=i;
            }
            if(repeated!=-1 && missing !=-1)
            {
                break;
            }
        }
        return new int[]{repeated,missing};
    }
}

class Solution2
{
    public int[] findMissingRepeatingNumbers(int[] nums) 
    {
        // better with map
        int n=nums.length;
        int repeated=-1;
        Map<Integer,Integer> dict=new HashMap<>();
        int actualSum=-0;
        int expectedSum=n*(n+1)/2;
        for(int ele : nums)
        {
            dict.put(ele,dict.getOrDefault(ele,0)+1);
            if(dict.get(ele)>=2)
            {
                repeated=ele;
            }
            actualSum+=ele;
        }
        int missing=expectedSum-actualSum+repeated;
        return new int[]{repeated,missing};
    }
}

class Solution3
{
    public int[] findMissingRepeatingNumbers(int[] nums) 
    {
        // better with hashArray
        int n=nums.length;
        int repeated=-1;
        int missing=-1;
        int hash[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            hash[nums[i]]++;
        }
        for(int i=1;i<hash.length;i++)
        {
            if(hash[i]==2)
            {
                repeated=i;
            }
            else if(hash[i]==0)
            {
                missing=i;
            }
            if(repeated!=-1 && missing !=-1)
            {
                break;
            }
        }
        return new int[]{repeated,missing};
    }
}

class Solution4
{
    public int[] findMissingRepeatingNumbers(int[] nums) 
    {
        // optimal with mathematical appraoch
        int n=nums.length;
        long repeated=-1; // x
        long missing=-1; // y
        long actualSum=0;
        long actualSquareSum=0;
        long expectedSum=((long)n*(n+1))/2;
        long expectedSquareSum=((long)n*(n+1)*(2*n+1))/6;
        for(int ele : nums)
        {
            actualSum+=(long)ele;
            actualSquareSum+=(long)ele*ele;
        }
        // S-Sn=val1
        long val1=actualSum-expectedSum; // 1. x-y 
        // S²-S²n=val2
        long val2= actualSquareSum-expectedSquareSum; //2. x²-y²
        val2=val2/val1; // x+y
        repeated=(val1+val2)/2; // x
        missing=repeated-val1; // y (using eqn 1)
        return new int[]{(int)repeated,(int)missing};
    }
    // optimal with xor appproach is in VS code
}