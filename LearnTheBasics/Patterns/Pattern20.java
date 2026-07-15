package LearnTheBasics.Patterns;



/* 

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

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

*/



class Solution 
{
    public void pattern20(int n) 
    {
        for(int i = 1 ; i<=n ; i++)
        {
            for(int s=1 ; s<=i ; s++)
            { // for stars
                System.out.print("*");
            }
            for(int b=2*(n-i) ; b>=1 ; b--)
            { // for blanks
                System.out.print(" ");
            }
            for(int s=1 ; s<=i ; s++)
            { // for stars
                System.out.print("*");
            }
            System.out.println();
        }

        // for lower part 

        for(int i =n-1 ; i>=1 ; i--)
        {
            for(int s=1 ; s<=i ; s++)
            { // for stars
                System.out.print("*");
            }
            for(int b=2*(n-i) ; b>=1 ; b--)
            { // for blanks
                System.out.print(" ");
            }
            for(int s=1 ; s<=i ; s++)
            { // for stars
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

