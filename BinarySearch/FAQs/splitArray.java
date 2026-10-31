package BinarySearch.FAQs;

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

MEDIUM
*/

class Solution1 
{
    public int largestSubarraySumMinimized(int[] a, int k) 
    {
        // linearSearch
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=-1;
        for(int n : a)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        for(int i=low;i<=high;i++)
        {
            int noOfSubArrays=calculate(a,i);
            if(noOfSubArrays<=k)
            {
                ans=i;
                break;
            }
        }
        return ans;
    }
    public int calculate(int[] a, int limit)
    {
        int subArrays=1;
        int sum=0;
        for(int i=0;i<a.length;i++)
        {
            if(sum+a[i]<=limit)
            {
                sum=sum+a[i];
            }
            else
            {
                subArrays++;
                sum=a[i];
            }
        }
        return subArrays;
    } 
}

class Solution2
{
    public int largestSubarraySumMinimized(int[] a, int k) 
    {
        // binarySearch
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=-1;
        for(int n : a)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int noOfSubArrays=calculate(a,mid);
            if(noOfSubArrays<=k)
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
    public int calculate(int[] a, int limit)
    {
        int subArrays=1;
        int sum=0;
        for(int i=0;i<a.length;i++)
        {
            if(sum+a[i]<=limit)
            {
                sum=sum+a[i];
            }
            else
            {
                subArrays++;
                sum=a[i];
            }
        }
        return subArrays;
    } 
}
