package BeginnerProblems.Patterns;

/* 

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

**********
****  ****
***    ***
**      **
*        *
*        *
**      **
***    ***
****  ****
**********


Print the pattern in the function given to you.


Constraints
1 <= n <= 100

EASY
*/

class Solution1
{
    public void pattern19(int n) 
    {
        // for upper part
        for(int i=n ; i>=1 ; i--)
        {
            // for stars
            for(int s=i ; s>=1 ; s--)
            { 
                System.out.print("*");
            }
            // for blank
            for(int b=1 ; b<=2*(n-i) ; b++)
            { 
                System.out.print(" ");
            }
            // for stars
            for(int s=i ; s>=1 ; s--)
            { 
                System.out.print("*");
            }
            System.out.println();
        }
       
        // for lower part  
        for(int i=1 ; i<=n ; i++)
        {
            // for stars
            for(int s=1 ; s<=i ; s++)
            { 
                System.out.print("*");
            }
            // for blanks
            for(int b=1 ; b<=2*(n-i) ; b++)
            { 
                System.out.print(" ");
            }
            // for stars
            for(int s=1 ; s<=i ; s++)
            { 
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class Solution2
{
    public void pattern19(int n) 
    {
        // for upper part
        for(int i=n;i>=1;i--)
        {
            //stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            // blanks
            for(int s=1;s<=2*(n-i);s++)
            {
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        // for lower part
        for(int i=1;i<=n;i++)
        {
            //stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            // blanks
            for(int s=1;s<=2*(n-i);s++)
            {
                System.out.print(" ");
            }
            // stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
    
class Solution3 
{
    public void pattern19(int n) 
    {
        // for upper part
        for(int i=0;i<n;i++)
        {
            //stars
            for(int j=0;j<n-i;j++)
            {
                System.out.print("*");
            }
            //blanks
            for(int s=0;s<2*i;s++)
            {
                System.out.print(" ");
            }
            //stars
            for(int j=0;j<n-i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        // for lower part
        for(int i=0;i<n;i++)
        {
            //stars
            for(int j=0;j<=i;j++)
            {
                System.out.print("*");
            }
            // blanks
            for(int s=0;s<2*(n-1-i);s++)
            {
                System.out.print(" ");
            }
            // stars
            for(int j=0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
