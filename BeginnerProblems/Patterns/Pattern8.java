package BeginnerProblems.Patterns;


/*

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

*********
 *******
  *****
   ***
    *

Print the pattern in the function given to you.

Constraints
1 <= n <= 100

EASY
*/

class Solution1 
{
    public void pattern8(int n) 
    {
        //optimal
        for(int i=n;i>=1;i--)
        {
            // for space
            for(int j =n-i ; j>=1 ;j--)
            {
                System.out.print(" ");
            }
            // for stars
            for(int j =(2*i)-1 ; j>=1 ; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class Solution2
{
    public void pattern8(int n) 
    {
        // optimal
        for(int i=n;i>=1;i--)
        {
            // for space
            for(int j=1;j<=n-i;j++)
            {
                System.out.print(" ");
            }
            //for stars
            for(int j=(2*i-1);j>=1;j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
    
class Solution3
{
    public void pattern8(int n) 
    {
        //optimal
        for(int i=0;i<n;i++)
        {
            // for space
            for(int j=0;j<i;j++)
            {
                System.out.print(" ");
            }
            //for stars
            for(int j=0;j<(2*(n-i)-1);j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
   