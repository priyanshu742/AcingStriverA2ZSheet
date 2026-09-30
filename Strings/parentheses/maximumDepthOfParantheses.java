package Strings.parentheses;

/*

A string s is a valid parentheses string (VPS) if it meets the following conditions:
It only contains digits 0-9, arithmetic operators +, -, *, /, and parentheses (, ).
The parentheses are balanced and correctly nested.

Your task is to compute the maximum nesting depth of parentheses in s. 
The nesting depth is the highest number of parentheses that are open at the same time at any point in the string.

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation: The deepest nested sub-expression is ((8)/4), which has 3 layers of parentheses.

Example 2:
Input: s = "(1)+((2))+(((3)))"
Output: 3
Explanation: The digit '3' is enclosed in 3 pairs of parentheses.


Constraints:
1 <= s.length <= 100
s consists of digits 0-9, arithmetic operators (+, -, *, /), and parentheses ( and ).
It is guaranteed that s is a valid parentheses string (VPS).

EASY
*/

class Solution1
{
    public int maxDepth(String s) 
    {
        int count=0;
        int depth=0;
        int size=s.length();
        for(int i=0;i<size;i++)
        {
            if(s.charAt(i)=='(')
            {
                count++;
                if(count>depth)
                {
                    depth=count;
                }
            }
            else if(s.charAt(i)==')')
            {
                count--;
            }
        }
        return depth;
    }
}

class Solution2
{
    public int maxDepth(String s) 
    {
        int count=0;
        int depth=0;
        for(char c : s.toCharArray())
        {
            if(c=='(')
            {
                count++;
                if(count>depth)
                {
                    depth=count;
                }
            }
            else if(c==')')
            {
                count--;
            }
        }
        return depth;
    }
}