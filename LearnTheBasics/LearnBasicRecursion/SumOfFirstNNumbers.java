package LearnTheBasics.LearnBasicRecursion;


/* 

Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.

Example 1
Input : N = 4
Output : 10
Explanation : first four natural numbers are 1, 2, 3, 4.
Sum is 1 + 2 + 3 + 4 => 10.

Example 2
Input : N = 2
Output : 3
Explanation : first two natural numbers are 1, 2.
Sum is 1 + 2 => 3.


Constraints
1 <= N <= 103


EASY
*/

class Solution 
{
    public int NnumbersSum(int N) 
    {
        //your code goes here
        if(N==0)
        {
            return 0;
        }
        else
        {
            return N+NnumbersSum(N-1);
        }
       
    }
}
    

