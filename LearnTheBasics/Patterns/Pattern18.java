package LearnTheBasics.Patterns;


/*

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

E 
D E 
C D E 
B C D E 
A B C D E

Print the pattern in the function given to you.

Constraints
1 <= n <= 26


*/


class Solution 
{
    public void pattern18(int n) 
    {
        for(int i=1 ; i<=n ; i++)
        {
            char c =(char)(65 + (n-i));
            for(int j=1 ; j<=i ; j++)
            {
                System.out.print(c + " ");
                c++;
            }
            System.out.println();
        }
    }
}
    

