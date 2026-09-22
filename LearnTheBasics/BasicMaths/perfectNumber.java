package LearnTheBasics.BasicMaths;

/*

You are given an integer n. You need to check if the number is a perfect number or not. 
Return true if it is a perfect number, otherwise, return false.
A perfect number is a number whose proper divisors (excluding the number itself) add up to the number itself.

Example 1:
Input: n = 6
Output: true
Explanation: Proper divisors of 6 are 1, 2, 3.
1 + 2 + 3 = 6.

Example 2:
Input: n = 4
Output: false
Explanation: Proper divisors of 4 are 1, 2.
1 + 2 = 3.


Constraints:
1 <= n <= 5000

EASY
*/

class Solution 
{
    public boolean isPerfect(int n) 
    {
        if(n==1)
        {
            return false;
        }
        int sum=1;
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                sum=sum+i;
                if(n/i!=i)
                {
                    sum=sum+n/i;
                }
            }
        }
        return sum==n;
    }
}