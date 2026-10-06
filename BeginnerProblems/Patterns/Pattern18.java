package BeginnerProblems.Patterns;


/*

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

E 
D E 
C D E 
B C D E 
A B C D E

Print the pattern in the function given to you.


Constraints
1 <= n <= 26

MEDIUM
*/

class Solution 
{
    public void pattern18(int n) 
    {
        for(int i=1 ; i<=n ; i++)
        {
            char c =(char)(65 + (n-i));
            for(int j=1 ; j<=i ; j++)
            {
                System.out.print(c + " ");
                c++;
            }
            System.out.println();
        }
    }
}

class Solution2 
{
    public void pattern18(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            char c=(char)('A'+n-i);
            for(int j=1;j<=i;j++)
            {
                System.out.print(c+" ");
                c++;
            }
            System.out.println();
        }
    }
}

class Solution3 
{
    public void pattern18(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            for(char ch=(char)('A'+n-i);ch<(char)('A'+n);ch++)
            {
                System.out.print(ch +" ");
            }
            System.out.println();
        }
    }
}