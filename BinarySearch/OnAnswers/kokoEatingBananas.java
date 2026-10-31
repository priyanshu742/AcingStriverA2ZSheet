package BinarySearch.OnAnswers;

/* 

A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas. 
An integer h represents the total time in hours to eat all the bananas.
Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas.
If the pile contains fewer than k bananas, the monkey eats all the bananas in that pile and does not consume any more bananas in that hour.
Determine the minimum number of bananas the monkey must eat per hour to finish all the bananas within h hours.

Example 1
Input: n = 4, nums = [7, 15, 6, 3], h = 8
Output: 5
Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly. So, he will take 8 hours to complete all the piles.  

Example 2
Input: n = 5, nums = [25, 12, 8, 14, 19], h = 5
Output: 25
Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly. So, he will take 5 hours to complete all the piles.


Constraints
1 <= n <= 104
n <= h <= 109
1 <= nums[i] <= 109

EASY 
*/

class Solution1
{
    public int minimumRateToEatBananas(int[] nums, int h) 
    {
        //  linearSearch
        int high=0;
        int ans=0;
        if(h<nums.length)
        {
            return -1;
        }
        for(int n : nums)
        {
            if(n>high)
            {
                high=n;
            }
        }
        for(int i=1;i<=high;i++)
        {
            int noOfHours=0;
            for(int n : nums)
            {
                noOfHours=noOfHours+(n+i-1)/i;
                if(noOfHours>h)
                {
                    break;
                }
            }
            if(noOfHours<=h)
            {
                ans=i;
                break;
            }
        }
        return ans; 
    }
}

class Solution2
{
    public int minimumRateToEatBananas(int[] nums, int h) 
    {
        // binarySearch 
        if(h<nums.length)
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
            long noOfHours=calculate(nums,mid,h);
            if(noOfHours<=h)
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
    public long calculate(int nums[],int rate,int h)
    {
        long hours=0;
        for(int n : nums)
        {
            hours=hours+(n+rate-1)/rate;
        }
        return hours;
    }
}

class Solution3
{
    public int minimumRateToEatBananas(int[] nums, int h) 
    {
        // binarySearch 
        // returns 1 if hours <=h
        // returns 2 if hours > h
        if(h<nums.length)
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
            int noOfHours=calculate(nums,mid,h);
            if(noOfHours==1)
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
    public int calculate(int nums[],int rate,int h)
    {
        long hours=0;
        for(int n : nums)
        {
            hours=hours+(n+rate-1)/rate;
            if(hours>h)
            {
                return 2;
            }
        }
        return 1;
    }
}