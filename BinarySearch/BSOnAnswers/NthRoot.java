package BinarySearch.BSOnAnswers;

/*

Given two numbers N and M, find the Nth root of M.

The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M.
If the Nth root is not an integer, return -1.

Example 1
Input: N = 3, M = 27
Output: 3
Explanation: The cube root of 27 is equal to 3.

Example 2
Input: N = 4, M = 69
Output:-1
Explanation: The 4th root of 69 does not exist. So, the answer is -1.


Constraints
1 <= N <= 30
1 <= M <= 109

EASY
*/


class Solution 
{
    public int NthRoot(int N, int M) 
    {
        int low=1;
        int high=M;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(pow(mid,N,M)==1)
            {
                return mid;
            }
            else if(pow(mid,N,M)==2)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1; 
    }

    public int pow(int mid,int N,int M)
    {
        // return 1 if ==M
        // return 2 if > M
        // return 0 if < M
        long ans=1;
        for(int i=1;i<=N;i++)
        {
            ans=ans*mid;
            if(ans>M)
            {
                return 2; 
            }
        }
        if(ans==M)
        {
            return 1;
        }
        return 0;
    }
}
