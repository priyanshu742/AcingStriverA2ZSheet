package LearnTheBasics;


/*

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:

1
22
333
4444
55555

Constraints

1 <= n <= 100

*/

class Solution 
{
    public void pattern4(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(i);
            }
        System.out.println();
        }
    }
}
    

