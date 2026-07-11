package LearnTheBasics.Patterns;


/*

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

    *
   ***
  *****
 *******
*********

Print the pattern in the function given to you.

Constraints
1 <= n <= 100


*/



class Solution 
{
    public void pattern7(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            for(int s=1 ; s<=n-i ; s++)
            {
                // for space
                System.out.print(" ");  
            }
            for(int j=1 ; j<=(2*i)-1 ; j++)
            {
                // for stars
                System.out.print("*");
            }
            System.out.println();  
        }
    }
}

    

