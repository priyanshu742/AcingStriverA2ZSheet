package BinarySearch.BSOnAnswers;

/* 

Given n roses and an array nums where nums[i] denotes that the 'ith' rose will bloom on the nums[i]th day, 
only adjacent bloomed roses can be picked to make a bouquet. Exactly k adjacent bloomed roses are required to make a single bouquet.
Find the minimum number of days required to make at least m bouquets, each containing k roses. Return -1 if it is not possible.

Example 1
Input: n = 8, nums = [7, 7, 7, 7, 13, 11, 12, 7], m = 2, k = 3
Output: 12
Explanation: On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, 
one with the first 3 and another with the last 3 flowers.

Example 2
Input: n = 5, nums = [1, 10, 3, 10, 2], m = 3, k = 2
Output: -1
Explanation: If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. 
But we are given only 5 flowers, so, we cannot make the bouquets.


Constraints
1 <= n <= 105
1 <= nums[i] <= 109
1 <= m <= 106
1 <= k <= n

MEDIUM
*/

class Solution 
{
    public int roseGarden(int n, int[] nums, int k, int m) 
    {
        if(n<(long)k*m)
        {
            return -1;
        }

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int x:nums)
        {
            high=Math.max(high,x);
            low=Math.min(low,x);
        }

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int bouquets=possible(nums,mid,k,n);

            if(bouquets>=m)
            {
                high=mid-1;
            }
            else if(bouquets<m)
            {
                low=mid+1;
            }
        }
        return low;
    }

    public int possible(int nums[],int day,int group,int size)
    {
        int count=0;
        int bouquets=0;
        for(int i=0;i<size;i++)
        {
            if(nums[i]<=day)
            {
                count++;
            }
            else
            {
                bouquets=bouquets+(count/group);
                count=0;
            }
        }
        bouquets=bouquets+(count/group);
        return bouquets;
    }
}



