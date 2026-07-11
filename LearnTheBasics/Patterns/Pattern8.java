package LearnTheBasics.Patterns;


/*

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

*********
 *******
  *****
   ***
    *

Print the pattern in the function given to you.

Constraints
1 <= n <= 100

*/


class Solution 
{
    public void pattern8(int n) 
    {
        for(int i=n;i>=1;i--)
        {
            for(int s =n-i ; s>=1 ;s--)
            {
                System.out.print(" ");
            }
            for(int j =(2*i)-1 ; j>=1 ; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

    

