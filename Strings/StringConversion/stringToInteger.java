package Strings.StringConversion;

/*

Implement the function myAtoi(s) which converts the given string s to a 32-bit signed integer (similar to the C/C++ atoi function).

Steps to Implement:
First, ignore any leading whitespace characters ' ' until the first non-whitespace character is found.
Check the next character to determine the sign. If it’s a '-', the number should be negative. If it’s a '+', the number should be positive. If neither is found, assume the number is positive.
Read the digits and convert them into a number. Stop reading once a non-digit character is encountered or the end of the string is reached. 
Leading zeros should be ignored during conversion.
The result should be clamped within the 32-bit signed integer range: [-2147483648, 2147483647]. 
If the computed number is outside this range, return -2147483648 if the number is less than -2147483648, or return 2147483647 if the number is greater than 2147483647.
Finally, return the computed number after applying all the above steps.

Example 1:
Input: s = " -12345"
Output: -12345
Explanation:
Ignore leading whitespaces.
The sign '-' is encountered, indicating the number is negative.
Digits 12345 are read and converted to -12345.

Example 2:
Input: s = "4193 with words"
Output: 4193
Explanation:
Read the digits 4193 and stop when encountering the first non-digit character (w).


Constraints:
0 ≤ s.length ≤ 200
s consists of English letters (both lowercase and uppercase), Digits '0' to '9', Characters: ' ', '+', '-', and '.'

EASY
*/

class Solution1
{
    public int myAtoi(String input) 
    {
        // optimal
        long ans=0;
        int start=0;
        int sign=1;
        while(start<input.length() && input.charAt(start)==' ')
        {
            start++;
        }
        if(start<input.length() && (input.charAt(start)=='+' || input.charAt(start)=='-'))
        {
            if(input.charAt(start)=='+')
            {
                sign=1;
            }
            else
            {
                sign=-1;
            }
            start++;
        }
        for(int i=start;i<input.length();i++)
        {
            if(input.charAt(i)>='0' && input.charAt(i)<='9')
            {
                ans=ans*10+(input.charAt(i)-'0');
                if(ans*sign>=Integer.MAX_VALUE)
                {
                    return Integer.MAX_VALUE;
                }
                if(ans*sign<=Integer.MIN_VALUE)
                {
                    return Integer.MIN_VALUE;
                }
            }
            else
            {
                break;
            }
        }
        return (int)(ans*sign);
    }
}

class Solution2 
{
    public int myAtoi(String input) 
    {
        // brute
        long ans=0;
        int start=0;
        int sign=1;
        while(start<input.length() && input.charAt(start)==' ')
        {
            start++;
        }
        if(start<input.length() && ( input.charAt(start)=='+' || input.charAt(start)=='-'))
        {
            if(input.charAt(start)=='+')
            {
                sign=1;
            }
            else
            {
                sign=-1;
            }
            start++;
        }
        int end=start;
        for(int i=start;i<input.length();i++)
        {
            if(input.charAt(i)>='0' && input.charAt(i)<='9')
            {
                end++;
            }
            else
            {
                break;
            }
        }
        StringBuilder str=new StringBuilder(input.substring(start,end));
        for(int i=0;i<str.length();i++)
        {
            ans=ans*10+(str.charAt(i)-'0');
            if(ans*sign>=Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            if(ans*sign<=Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }
        }
        return (int)(ans*sign);
    }
}