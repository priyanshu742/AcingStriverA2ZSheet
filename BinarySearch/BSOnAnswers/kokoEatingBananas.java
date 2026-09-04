package BinarySearch.BSOnAnswers;

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

HARD   
*/

class Solution 
{
    public int minimumRateToEatBananas(int[] nums, int h) 
    {
        int max=Integer.MIN_VALUE;
        for(int n: nums)
        {
           max=Math.max(n,max);
        }

        int low=1;
        int high=max;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            long totalHours=0;

            for(int n: nums)
            {
                totalHours=totalHours+((long)n+mid-1)/mid;
            }

            if(totalHours<=h)
            {                    
                high=mid-1;
            }
            else if(totalHours>h)
            {
                low=mid+1;
            }
        }
        return low;
    }
}
