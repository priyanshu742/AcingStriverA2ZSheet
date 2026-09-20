package Strings.BasicAndEasy;

/*

A valid parentheses string is defined by the following rules:
It is the empty string "".
If A is a valid parentheses string, then so is "(" + A + ")".
If A and B are valid parentheses strings, then A + B is also valid.

A primitive valid parentheses string is a non-empty valid string that cannot be split into two or more non-empty valid parentheses strings.
Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

Example 1
Input: s = "((()))"
Output: "(())"
Explanation:
The input string is a single primitive: "((()))".
Removing the outermost layer yields: "(())".

Example 2
Input: s = "()(()())(())"
Output: "()()()"
Explanation:
Primitive decomposition: "()" + "(()())" + "(())"
After removing outermost parentheses: "" + "()()" + "()"
Final result: "()()()".


Constraints
1 <= s.length <= 10⁵
s[i] is either '(' or ')'
s is a valid parentheses string

EASY
*/

class Solution 
{
    public String removeOuterParentheses(String s) 
    {
        StringBuilder ans=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(count>0)
                {
                    ans.append(s.charAt(i));
                }
                count++;
            }
            if(s.charAt(i)==')')
            {
                count--;
                if(count>0)
                {
                    ans.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}
