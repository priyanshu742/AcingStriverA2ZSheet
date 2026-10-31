package BinarySearch.OnAnswers;

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

class Solution1 
{
    // LinearSearch
    public int NthRoot(int N, int M) 
    {
        for(int i=1;i<=M;i++)
        {
            int calculate=root(i,N,M);
            if(calculate==1)                
            {
                return i;
            }
            else if(calculate==2)
            {
                break;
            }
        }
        return -1;
    }
    public int root(int mid, int N,int M) 
    {
        long result=1;
        for(int i=0;i<N;i++)
        {
            result*=mid;
            if(result>M)
            {
                return 2;
            }
        }
        if(result==M)
        {
            return 1;
        }
        return 0;
    }
}

class Solution2
{
    public int NthRoot(int N, int M) 
    {
        // binarySearch
        // returns 2 if result > M
        // returns 1 if result == M
        // returns 0 if result < M
        int low=1;
        int high=M;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int calculate=pow(mid,N,M);
            if(calculate==1)
            {
                return mid;
            }
            else if(calculate==2)
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
    public int pow(int mid, int N,int M) 
    {
        long result=1;
        for(int i=0;i<N;i++)
        {
            result*=mid;
            if(result>M)
            {
                return 2;
            }
        }
        if(result==M)
        {
            return 1;
        }
        return 0;
    }
}
