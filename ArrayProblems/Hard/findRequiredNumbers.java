package ArrayProblems.Hard;


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
class Solution 
{
    public int[] findMissingRepeatingNumbers(int[] nums) 
    {
        //Mathematics optimal approach

        //S-Sn
        //S2 -S2n
        int size=nums.length;

        int S=0;
        long Sn=(size*(size+1))/2;

        long S2=0;
        long S2n=(size*(size+1)*((2*size)+1))/6;
        for(int i=0;i<nums.length;i++)
        {
            S+=nums[i];
            S2+=(long)(nums[i]*nums[i]);
        }

        long val1=S-Sn; //x-y
        long val2=S2-S2n;
        val2=val2/val1; //x+y

        long x=(val1+val2)/2; // twice
        long y=x-val1; // missing

        return new int[]{(int)x,(int)y} ;
    }
}
