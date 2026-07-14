package LearnTheBasics.Patterns;

/*

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA

Print the pattern in the function given to you.

Constraints
1 <= n <= 26

*/



class Solution 
{
    public void pattern17(int n) 
    {
        for(int i=1; i<=n; i++)
        {
            for(int s=1 ; s<=(n-i); s++)
            {
                System.out.print(" ");
            }
            for(int j=1 ; j<=i; j++)
            {
                System.out.print((char)(65 + (j-1)));
            }
            for(int k=i-1 ; k>=1; k--)
            {
                System.out.print((char)(65 + (k-1)));
            }
            System.out.println();  
        }
    }
}

    

