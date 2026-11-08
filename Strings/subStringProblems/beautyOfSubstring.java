package Strings.subStringProblems;

import java.util.HashMap;
import java.util.Map;

/*

The beauty of a string is defined as the difference between the frequency of the most frequent character and the least frequent character (excluding characters that do not appear) in that string.
Given a string s, return the sum of beauty values of all possible substrings of s.

Example 1:
Input: s = "xyx"
Output: 1
Explanation: The substrings with non-zero beauty are:
- "xyx" → frequencies: x:2, y:1 → beauty = 2 - 1 = 1
- "xy" → x:1, y:1 → beauty = 0
- "yx" → y:1, x:1 → beauty = 0
- "x" or "y" → beauty = 0
Total sum = 1 (from "xyx") = 1

Example 2:
Input: s = "aabcbaa"
Output: 17
Explanation: Various substrings such as "aabc", "bcba", etc., have non-zero beauty values. Summing all gives 17.


Constraints:
1 <= s.length <= 500
s consists of only lowercase English letters ('a' to 'z')

EASY
*/

class Solution1 
{
    public int beautySum(String s) 
    {
        // brute
        int total=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                total=total+calculateBeauty(s,i,j);
            }
        }
        return total;
    }
    public int calculateBeauty(String s,int left,int right)
    {
        Map<Character,Integer> hash=new HashMap<>();
        for(int i=left;i<=right;i++)
        {
            char c=s.charAt(i);
            hash.put(c,hash.getOrDefault(c,0)+1);
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=left;i<=right;i++)
        {
            char c=s.charAt(i);
            if(hash.get(c)>max)
            {
                max=hash.get(c);
            }
            if(hash.get(c)<min)
            {
                min=hash.get(c);
            }
        }
        return max-min;
    } 
}

class Solution2 
{
    public int beautySum(String s) 
    {
        // optimal
        int total=0;
        for(int i=0;i<s.length();i++)
        {
            int freq[]=new int[26];
            for(int j=i;j<s.length();j++)
            {
                char c=s.charAt(j);
                freq[c-'a']++;
                total=total+calculateBeauty(freq);
            }
        }
        return total;
    }
    public int calculateBeauty(int []freq) 
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]!=0)
            {
                if(freq[i]>max)
                {
                    max=freq[i];
                }
                if(freq[i]<min)
                {
                    min=freq[i];
                }
            }
        }
        return max-min;
    }
}