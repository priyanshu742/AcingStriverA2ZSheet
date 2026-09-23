package BeginnerProblems.BasicMaths;

/*

You are given an integer n. You need to return the number of odd digits present in the number.
The number will have no leading zeroes, except when the number is 0 itself.

Example 1:
Input: n = 5
Output: 1
Explanation: 5 is an odd digit.

Example 2:
Input: n = 25
Output: 1
Explanation: The only odd digit in 25 is 5.


Constraints:
0 <= n <= 5000
n will contain no leading zeroes except when it is 0 itself.

EASY
*/

class Solution 
{
    public int countOddDigit(int n) 
    {
        int count=0;
        while(n!=0)
        {
            int digit=n%10;
            if(digit%2!=0)
            {
                count++;
            }
            n=n/10;
        }
        return count;
    }
}