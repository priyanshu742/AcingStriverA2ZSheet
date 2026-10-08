package BeginnerProblems.basicRecursion;

/*

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1
Input : n = 2
Output : 1
Explanation : F(2) = F(1) + F(0) => 1 + 0 => 1.

Example 2
Input : n = 3
Output : 2
Explanation : F(3) = F(2) + F(1) => 1 + 1 => 2.


Constraints
0 <= n <= 20

EASY
*/

class Solution1
{
    public int fib(int n) 
    {
        // recursive
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
    
class Solution2
{
    public int fib(int n) 
    {
        //optimal recursive;
        int memo[]=new int[n+1];
        return fibHelper(n,memo);
    }
    public int fibHelper(int n,int []memo)
    {
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        if(memo[n]!=0)
        {
            return memo[n];
        }
        memo[n]=fibHelper(n-1,memo)+fibHelper(n-2,memo);
        return memo[n];
    }
}

class Solution3 
{
    public int fib(int n) 
    {
        // iterative
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        int prev2=0;
        int prev1=1;
        int current=0;
        for(int i=2;i<=n;i++)
        {
            current=prev2+prev1;
            prev2=prev1;
            prev1=current;
        }
        return current;
    }
}