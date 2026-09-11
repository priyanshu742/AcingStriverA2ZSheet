package BinarySearch.BSOnAnswers;


/*

Given an integer array a of size n and an integer k.
Split the array a into k non-empty subarrays such that the largest sum of any subarray is minimized. 
Return the minimized largest sum of the split.

Example 1
Input: a = [1, 2, 3, 4, 5], k = 3
Output:6
Explanation: There are many ways to split the array a[] into k consecutive subarrays. 
The best way to do this is to split the array a[] into [1, 2, 3], [4], and [5], where the largest sum among the three subarrays is only 6.

Example 2
Input: a = [3,5,1], k = 3
Output: 5
Explanation: There is only one way to split the array a[] into 3 subarrays, i.e., [3], [5], and [1]. 
The largest sum among these subarrays is 5.


Constraints
1 ≤ n ≤ 104
1 ≤ k ≤ n
1 ≤ a[i] ≤ 104

HARD
*/

class Solution 
{
    public int largestSubarraySumMinimized(int[] a, int k) 
    {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int n:a)
        {
            if(n>low)
            {
                low=n;
            }
            high=high+n;
        }

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int count=countSum(a,mid);

            if(count<=k)
            {
                high=mid-1;
            }
            else if(count>k)
            {
                low=mid+1;
            }
        }
        return low;
    }
    
    public int countSum(int a[],int limit)
    {
        int count=1;
        int total=0;
        for(int n:a)
        {
            if(total+n>limit)
            {
                count++;
                total=n;
            }
            else
            {
                total=total+n;
            }
        }
        return count;
    }
}

