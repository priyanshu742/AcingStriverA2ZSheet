package BinarySearch.BSOnAnswers;

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

MEDIUM
*/

class Solution 
{
    public int floorSqrt(int n) 
    {
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
        return ans;
        //return high;
    }
}