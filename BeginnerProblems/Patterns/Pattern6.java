package BeginnerProblems.Patterns;

/* 

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

12345
1234
123
12
1

Print the pattern in the function given to you.

Constraints
1 <= n <= 100

EASY
*/



class Solution1
{
    public void pattern6(int n) 
    {
        //optimal
        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

class Solution2 
{
    public void pattern6(int n) 
    {
        //optimal
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n-i+1;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}