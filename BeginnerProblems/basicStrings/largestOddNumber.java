package BeginnerProblems.basicStrings;

/*

Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.
The number returned should not have leading zero's. But the given input string may have leading zero. (If no odd number is found, then return empty string.)

Example 1:
Input : s = "5347"
Output : "5347"
Explanation :
The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
So the largest among all the possible odd numbers for given string is 5347.

Example 2:
Input : s = "0214638"
Output : "21463"
Explanation :
The different odd numbers that can be formed by the given string are --> 1, 3, 21, 63, 463, 1463, 21463.
We cannot include 021463 as the number contains leading zero.
So largest odd number in given string is 21463.

Example 3:
Input : s = "0032579"
Output: "32579"


Constraints:
1 <= s.length <= 103
'0' <= s[i] <= '9'

EASY
*/

class Solution 
{    
    public String largeOddNum(String s) 
    {
        // substring is required here
        for(int i=s.length()-1;i>=0;i--)
        {
            int digit=s.charAt(i)-'0';
            if(digit%2!=0)
            {   
                int start=0;
                while(s.charAt(start)=='0' && start<=i)
                {
                    start++;
                }
                return s.substring(start,i+1);
            }
        }
        return "";
    }
}