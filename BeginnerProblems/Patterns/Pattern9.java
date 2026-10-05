package BeginnerProblems.Patterns;

/* 

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

    * 
   ***
  *****
 *******
*********
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
    public void pattern9(int n) 
    {
        for(int i=1 ; i<=n ; i++)
        {
            //space
            for(int s=1 ; s<=n-i ; s++)
            {
                System.out.print(" ");
            }
            //stars
            for(int j=1 ; j<=(2*i) -1 ; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n ; i>=1 ; i--)
        {
            for(int s=n-i ; s>=1 ; s--)
            {
                System.out.print(" ");
            }
            for(int j=(2*i)-1 ; j>=1 ; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
   
class Solution2 
{
    public void pattern9(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            // space
            for(int s=0;s<n-i;s++)
            {
                System.out.print(" ");
            }
            // stars
            for(int j=0;j<2*i-1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for(int i=n;i>=1;i--)
        {
            // space
            for(int s=n-i;s>=1;s--)
            {
                System.out.print(" ");
            }
            // stars
            for(int j=0;j<2*i-1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
