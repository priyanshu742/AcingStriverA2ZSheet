package BeginnerProblems.Patterns;

/* 

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *


Print the pattern in the function given to you.


Constraints
1 <= n <= 100

EASY
*/

class Solution1 
{
    public void pattern20(int n) 
    {
        // for upper part
        for(int i = 1 ; i<=n ; i++)
        {
            // for stars
            for(int s=1 ; s<=i ; s++)
            { 
                System.out.print("*");
            }
            // for blanks
            for(int b=2*(n-i) ; b>=1 ; b--)
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

        // for lower part 
        for(int i =n-1 ; i>=1 ; i--)
        {
            // for stars
            for(int s=1 ; s<=i ; s++)
            { 
                System.out.print("*");
            }
            // for blanks
            for(int b=2*(n-i) ; b>=1 ; b--)
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
    public void pattern20(int n) 
    {
        // for upper part
        for(int i=1;i<=n;i++)
        {
            // stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            // blank
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
        //for lower part
        for(int i=n-1;i>=1;i--)
        {
            //stars
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            //blank
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
    public void pattern20(int n) 
    {
        for(int i=1;i<=2*n-1;i++)
        {
            int stars=i;
            int space=2*(n-i);
            if(i>n)
            {
                stars=2*n-i;
                space=2*(i-n);
            }
            //stars
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }
            // blank
            for(int s=1;s<=space;s++)
            {
                System.out.print(" ");
            }
            // stars
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class Solution4
{
    public void pattern20(int n) 
    {
        int space=2*n-2;
        for(int i=1;i<=2*n-1;i++)
        {
            int stars=i;
            if(i>n)
            {
                stars=2*n-i;
            }
            //stars
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }
            // blank
            for(int s=1;s<=space;s++)
            {
                System.out.print(" ");
            }
            // stars
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }
            System.out.println();
            if(i<n)
            {
                space=space-2;
            }
            else
            {
                space=space+2;
            }
        }
    }
}