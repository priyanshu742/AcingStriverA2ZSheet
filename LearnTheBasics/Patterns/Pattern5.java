package LearnTheBasics.Patterns;


/* 

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

*****
****
***
**
*

Constraints

1 <= n <= 100

*/



class Solution 
{
    public void pattern5(int n) 
    {
        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
        System.out.println();
        }
    }
}
    

