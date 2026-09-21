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

class Solution 
{
    public double myPow(double x, int n) 
    {
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
