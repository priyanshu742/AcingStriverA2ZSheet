package Recursion.implementationProblems;

/*

Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn.
Note : In output print 6 digits places after decimal point.

Example 1:
Input : x = 2.0000 , n = 10
Output : 1024.0000
Explanation : Answer = 2^10 => 1024.

Example 2:
Input : x = 2.0000 , n = -2
Output : 0.2500
Explanation : Answer = 2^(-2) = 1/4 => 0.25


Constraints:
-100.0 <= x <= 100.0
-231 <= n <= 231 - 1
-104 <= xn <= 104
Either x is not zero or n>0.
n is an integer.

EASY
*/

class Solution1 
{
    public double myPow(double x, int n) 
    {
        // brute
        long M=n;
        int negative=0;
        if(M<0)
        {
            M=-M;
            negative=1;
        }
        double ans=1;
        for(int i=1;i<=M;i++)
        {
            ans=ans*x;
        }
        if(negative==1)
        {
            ans=1/ans;
        }
        return ans;
    }
}

class Solution2 
{
    public double myPow(double x, int n) 
    {
        // optimal without recursion
        long N=n;
        int negative=0;
        if(N<0)
        {
            negative=1;
            N=-N;
        }
        double ans=1;
        while(N>0)
        {
            // N is odd
            if(N%2==1)
            {
                ans=ans*x;
                N=N-1;
            }
            // N is even
            else if(N%2==0)
            {
                N=N/2;
                x=x*x;
            }
        }
        if(negative==1)
        {
            ans=1/ans;
        }
        return ans;
    }
}

class Solution3
{
    public double myPow(double x, int n) 
    {
        // optimal with recursion
        long M=n;
        int negative=0;
        if(M<0)
        {
            M=-M;
            negative=1;
        }
        long ans=1;
        double result=pow(x,M,ans);
        if(negative==1)
        {
            result=1/result;
        }
        return result;
    }
    public double pow(double x, long M,double ans) 
    {
        if(M==0)
        {
            return ans;
        }
        // M is odd
        if(M%2==1)
        {
            ans=ans*x;
        }
        // M is even
        x=x*x;
        return pow(x,M/2,ans);
    }
}

class Solution4
{
    public double myPow(double x, int n) 
    {
        // optimal with recursion
        if(n<0)
        {
            x=1/x;
            n=-n;
        }
        return power(x,n);
    }
    public double power(double x,int n)
    {
        if(n==0)
        {
            return 1;
        }
        double half=power(x,n/2);
        if(n%2==0)
        {
            return half*half;
        }
        else
        {
            return half*half*x;
        }   
    }
}
