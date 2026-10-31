package BinarySearch.OnAnswers;


/*

Given an array of integers nums and an integer limit as the threshold value, 
find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, 
the sum of the division results is less than or equal to the threshold value.
After dividing each element by the chosen divisor, take the ceiling of the result (i.e., round up to the next whole number).

Example 1
Input: nums = [1, 2, 3, 4, 5], limit = 8
Output: 3
Explanation: We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
The sum is 9(1 + 1 + 2 + 2 + 3) if we choose 2 as a divisor.
Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. 
Now, their sum is equal to 7 <= 8 i.e. the threshold value. 
So, 3 is the minimum possible answer.

Example 2
Input: nums = [8,4,2,3], limit = 10
Output: 2
Explanation: If we choose 1, we get 17 as the sum. If we choose 2, we get 9 (4+2+1+2) <= 10 as the answer. So, 2 is the answer.


Constraints
1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= limit <= 106

EASY
*/

class Solution1
{
    public int smallestDivisor(int[] nums, int limit) 
    {
        //LinearSearch
        if(limit<nums.length)
        {
            return -1;
        }
        int high=Integer.MIN_VALUE;
        for(int n : nums)
        {
            if(n>high)
            {
                high=n;
            }
        }
        for(int i=1;i<=high;i++)
        {
            int sum=0;
            for(int n : nums)
            {
                sum=sum+(n+i-1)/i;
            }
            if(sum<=limit)
            {
                return i;
            }
        }
        return high;
    }
}

class Solution2 
{
    public int smallestDivisor(int[] nums, int limit) 
    {
        // binarySearch
        if(limit<nums.length)
        {
            return -1;
        }
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int n : nums)
        {
            if(n>high)
            {
                high=n;
            }
        }
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int threshold=function(nums,mid);
            if(threshold<=limit)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans; // return low
    }
    public int function(int[] nums, int divisor)
    {
        int sum=0;
        for(int n : nums)
        {
            sum=sum+(n+divisor-1)/divisor;
        }
        return sum;
    } 
}