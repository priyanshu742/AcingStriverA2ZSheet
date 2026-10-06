package BeginnerProblems.Patterns;

/*
 
Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

ABCDE
ABCD
ABC
AB
A

Print the pattern in the function given to you.


Constraints
1 <= n <= 26

EASY
*/

class Solution1
{
    public void pattern15(int n) 
    {
        for(int i= n; i>=1 ; i--)
        {
            for(int j=1 ; j<=i ; j++)
            {
                System.out.print((char)('A' + (j-1)));
            }
            System.out.println();
        }
    }
}
    
class Solution2
{
    public void pattern15(int n) 
    {
        for(int i=n;i>=1;i--)
        {
            for(int ch='A';ch<'A'+i;ch++)
            {
                System.out.print((char)(ch));
            }
            System.out.println();
        }
    }
}

class Solution3
{
    public void pattern15(int n) 
    {
        for(int i=0;i<n;i++)
        {
            for(int ch='A';ch<='A'+(n-i-1);ch++)
            {
                System.out.print((char)(ch));
            }
            System.out.println();
        }
    }
}

