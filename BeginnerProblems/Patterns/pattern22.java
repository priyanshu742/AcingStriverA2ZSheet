package BeginnerProblems.Patterns;

/*

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

5 5 5 5 5 5 5 5 5 
5 4 4 4 4 4 4 4 5 
5 4 3 3 3 3 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 2 1 2 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 3 3 3 3 4 5 
5 4 4 4 4 4 4 4 5 
5 5 5 5 5 5 5 5 5

Print the pattern in the function given to you.

Example 1:
Input: n = 4
Output:
https://static.takeuforward.org/content/1789474154_IkCwzjQa.webp

Example 2:
Input: n = 2
Output:
https://static.takeuforward.org/content/1789474161_wHZwjHX3.webp

MEDIUM
*/

class Solution 
{
    public void pattern22(int n) 
    {
        for(int i=0;i<2*n-1;i++)
        {
            for(int j=0;j<2*n-1;j++)
            {
                int top=i;
                int bottom=2*n-2-i;
                int left=j;
                int right=2*n-2-j;
                int minimum=Math.min(Math.min(top,bottom),Math.min(right,left));                
                System.out.print(n-minimum+" ");
            }
            System.out.println();
        }
    }
}