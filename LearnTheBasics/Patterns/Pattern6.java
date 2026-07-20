package LearnTheBasics.Patterns;


/* 


Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

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



class Solution 
{
    public void pattern6(int n) 
    {
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
    


