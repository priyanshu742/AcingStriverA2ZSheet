package LearnTheBasics.Patterns;

/*

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15

Print the pattern in the function given to you.

Constraints
1 <= n <= 100

*/


class Solution 
{
    public void pattern13(int n) 
    {
        int count=1;
        for(int i =1 ; i<=n ; i++)
        {
            for(int j= 1 ; j<=i ; j++)
            {
                System.out.print(count + " ");
                count= count + 1;
            }
            System.out.println();
        }
    }
}

