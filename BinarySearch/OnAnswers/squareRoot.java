package BinarySearch.OnAnswers;

/*

Given a positive integer n. Find and return its square root.
If n is not a perfect square, then return the floor value of sqrt(n).

Example 1
Input: n = 36
Output: 6
Explanation: 6 is the square root of 36.

Example 2
Input: n = 28
Output: 5
Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5.


Constraints
0 <= n <= 231 - 1

EASY
*/

class Solution1 
{
    public int floorSqrt(int n) 
    {
        // linearSearch
        if(n==0)
        {
            return 0;
        }
        int ans=1;
        for(int i=1;i<=n/i;i++)
        {
            ans=i;
        }
        return ans;
    }
}

class Solution2 
{
    public int floorSqrt(int n) 
    {
        // binarySearch
        if(n==0)
        {
            return 0;
        }
        int low=1;
        int high=n;
        int ans=1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mid<=n/mid)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans; // return high
    }
}