package LearnTheBasics.Patterns;

/*

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

A
BB
CCC
DDDD
EEEEE

Print the pattern in the function given to you.


Constraints
1 <= n <= 26

*/



class Solution 
{
    public void pattern16(int n) 
    {
        for(int i =1 ; i<=n ; i++)
        {
            for(int j =1 ; j<=i ; j++)
            {
                System.out.print((char)('A' + (i-1)));
            }
            System.out.println();
        }
    }
}

    

