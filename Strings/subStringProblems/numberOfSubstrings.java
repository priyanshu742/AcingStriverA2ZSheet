package Strings.subStringProblems;

/*

You are given a string s consisting of lowercase English letters from 'a' to 'j'.
A substring is considered valid if at most one character occurs an odd number of times in that substring.
Return the total number of valid substrings in s.
A substring is a contiguous, non-empty sequence of characters within a string.

Example 1:
Input: s = "aba"
Output: 4
Explanation: The valid substrings are "a", "b", "a", and "aba". Each contains at most one character with an odd frequency.

Example 2:
Input: s = "aabb"
Output: 9
Explanation: There are 10 substrings in total. The only invalid substring is "ab", where both 'a' and 'b' occur an odd number of times. Hence, the answer is 9.


Constraints:
1 <= s.length <= 105
s consists only of lowercase English letters from 'a' to 'j'.

HARD
*/

class Solution1
{
    public long countSubstrings(String s) 
    {
        // brute
        long count=0;
        for(int i=0;i<s.length();i++)
        {
            int freq[]=new int[26];
            int oddCount=0;
            for(int j=i;j<s.length();j++)
            {
                int index=s.charAt(j)-'a';
                freq[index]++;
                if(freq[index]%2==1)
                {
                    oddCount++;
                }
                else
                {
                    oddCount--;
                }
                if(oddCount<=1)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
