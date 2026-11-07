package Strings.subStringProblems;

/*

Given a string s, return the longest palindromic substring in s.
A palindromic substring is a contiguous sequence of characters within the string that reads the same forward and backward.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation:
Both "bab" and "aba" are valid palindromic substrings of length 3. Return either.

Example 2:
Input: s = "cbbd"
Output: "bb"
Explanation:
The longest palindrome is "bb" of length 2.


Constraints:
1 <= s.length <= 1000
s consists of only English letters (both lowercase and uppercase) and digits.

MEDIUM
*/

class Solution1 
{
    public String longestPalindrome(String s) 
    {
        // brute
        int maxLen=0;
        String longest="";
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(checkPalindrome(s,i,j)==1)
                {
                    if(j-i+1>maxLen)
                    {
                        maxLen=j-i+1;
                        longest=s.substring(i,j+1);
                    }
                }
            }
        }
        return longest;
    }
    public int checkPalindrome(String s,int left,int right) 
    {
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
}

class Solution2 
{
    public String longestPalindrome(String s) 
    {
        // optimal
        int maxLen=0;
        String longest="";
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            // odd length
            int left=i;
            int right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right))
            {
                if(right-left+1>maxLen)
                {
                    maxLen=right-left+1;
                    longest=s.substring(left,right+1);
                }
                left--;
                right++;
            }
            // even length
            left=i;
            right=i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right))
            {
                if(right-left+1>maxLen)
                {
                    maxLen=right-left+1;
                    longest=s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        return longest;
    }
}

class Solution3
{
    public String longestPalindrome(String s) 
    {
        // optimal
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            // oddLength
            int oddPalindrome[]=expandAroundCentre(s,i,i);
            if(oddPalindrome[1]-oddPalindrome[0]>(end-start))
            {
                start=oddPalindrome[0];
                end=oddPalindrome[1];
            }
            // evenLength
            int evenPalindrome[]=expandAroundCentre(s,i,i+1);
            if(evenPalindrome[1]-evenPalindrome[0]>(end-start))
            {
                start=evenPalindrome[0];
                end=evenPalindrome[1];
            }
        }
        return s.substring(start,end+1);

    }
    public int[] expandAroundCentre(String s,int left,int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return new int[]{left+1,right-1};
    } 
}