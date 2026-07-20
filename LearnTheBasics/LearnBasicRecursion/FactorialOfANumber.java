package LearnTheBasics.LearnBasicRecursion;

/* 

You are given an integer n. Return the value of n! or n factorial.
Factorial of a number is the product of all positive integers less than or equal to that number.

Example 1
Input: n = 2
Output: 2
Explanation: 2! = 1 * 2 = 2.

Example 2
Input: n = 0
Output: 1
Explanation: 0! is defined as 1.

Constraints
0 <= n <= 10

EASY
*/

class Solution 
{
    public int factorial(int n) 
    {
        if(n==1)
        {
            return 1;
        }
        if(n==0)
        {
            return 1;
        }
        else
        {
            return n*factorial(n-1);
        }

    }
}
    

