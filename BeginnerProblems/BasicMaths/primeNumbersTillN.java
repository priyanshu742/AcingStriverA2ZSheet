package BeginnerProblems.basicMaths;

/*

You are given an integer n. You need to find out the number of prime numbers in the range [1, n] (inclusive). 
Return the number of prime numbers in the range.
A prime number is a number which has no divisors except, 1 and itself.

Example 1:
Input: n = 6
Output: 3
Explanation: Prime numbers in the range [1, 6] are 2, 3, 5.

Example 2:
Input: n = 10
Output: 4
Explanation: Prime numbers in the range [1, 10] are 2, 3, 5, 7.


Constraints:
2 <= n <= 1000

EASY
*/

class Solution1 
{
    public int primeUptoN(int n) 
    {
        // brute
        if(n==1)
        {
            return 0;
        }
        int prime=0;
        for(int i=2;i<=n;i++)
        {
            int flag=1;
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    flag=2;
                    break;
                }
            }
            if(flag==1)
            {
                prime++;
            }
        }
        return prime;
    }
}

class Solution2
{
    public int primeUptoN(int n) 
    {
        // brute
        if(n==1)
        {
            return 0;
        }
        int prime=0;
        for(int i=2;i<=n;i++)
        {
            int flag=1;
            for(int j=2;j*j<=i;j++)
            {
                if(i%j==0)
                {
                    flag=2;
                    break;
                }
            }
            if(flag==1)
            {
                prime++;
            }
        }
        return prime;
    }
}


class Solution3
{
    // optimal
    public int primeUptoN(int n) 
    {
        // 0 means prime
        // 1 means not prime;
        int prime[]=new int[n+1];
        int count=0;
        for(int i=2;i*i<=n;i++)
        {
            if(prime[i]==0)
            {
                for(int j=i*i;j<=n;j=j+i)
                {
                    prime[j]=1;
                }
            }
        }
        for(int i=2;i<=n;i++)
        {
            if(prime[i]==0)
            {
                count++;
            }
        }
        return count;      
    }
}