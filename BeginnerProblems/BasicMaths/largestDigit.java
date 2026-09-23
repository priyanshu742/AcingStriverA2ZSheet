package BeginnerProblems.BasicMaths;

/* 

You are given an integer n. Return the largest digit present in the number.

Example 1:
Input: n = 25
Output: 5
Explanation: The largest digit in 25 is 5.

Example 2:
Input: n = 99
Output: 9
Explanation: The largest digit in 99 is 9.


Constraints:
0 <= n <= 5000
n will contain no leading zeroes except when it is 0 itself.

EASY
*/

class Solution 
{
    public int largestDigit(int n) 
    {
        int maxdigit=0;
        n=Math.abs(n);
        while(n!=0)
        {
            int digit=n%10;
            if(digit>maxdigit)
            {
                maxdigit=digit;
            }
            n=n/10;
            if(maxdigit==9)
            {
                break;
            }
        }
        return maxdigit;
    }
}