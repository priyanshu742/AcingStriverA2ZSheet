package BeginnerProblems.Patterns;

/*

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

A
BB
CCC
DDDD
EEEEE

Print the pattern in the function given to you.


Constraints
1 <= n <= 26

EASY
*/


class Solution1
{
    public void pattern16(int n) 
    {
        for(int i =1 ; i<=n ; i++)
        {
            for(int j =1 ; j<=i ; j++)
            {
                System.out.print((char)('A' + (i-1)));
            }
            System.out.println();
        }
    }
}

class Solution2 
{
    public void pattern16(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            char ch=(char)('A'+i-1);
            for(int j=1;j<=i;j++)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

class Solution3
{
    public void pattern16(int n) 
    {
        for(int i=0;i<n;i++)
        {
            char ch=(char)('A'+i);
            for(int j=0;j<=i;j++)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

    

