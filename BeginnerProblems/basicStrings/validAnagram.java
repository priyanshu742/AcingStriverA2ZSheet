package BeginnerProblems.basicStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input : s = "anagram" , t = "nagaram"
Output : true
Explanation :
We can rearrange the characters of string s to get string t as frequency of all characters from both strings is same.

Example 2:
Input : s = "dog" , t = "cat"
Output : false
Explanation :
We cannot rearrange the characters of string s to get string t as frequency of all characters from both strings is not same.


Constraints:
1 <= s.length , t.length <= 5*104
s and t consist of only lowercase English letters

EASY
*/

class Solution1
{  
    public boolean anagramStrings(String s, String t) 
    {
        // brute
        if(s.length()!=t.length())
        {
            return false;
        }
        char charS[]=s.toCharArray();
        char charT[]=t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        return Arrays.equals(charS,charT);
    }
}

class Solution2 
{  
    public boolean anagramStrings(String s, String t) 
    {
        // optimal
        if(s.length()!=t.length())
        {
            return false;
        }
        int charArray[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            charArray[s.charAt(i)-'a']++;
            charArray[t.charAt(i)-'a']--;
        }
        for(int count : charArray)
        {
            if(count!=0)
            {
                return false;
            }
        }
        return true;
    }
}

class Solution3
{  
    public boolean anagramStrings(String s, String t) 
    {
        // better
        if(s.length()!=t.length())
        {
            return false;
        }
        Map<Character,Integer> mapS=new HashMap<>();
        Map<Character,Integer> mapT=new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            mapS.put(s.charAt(i),mapS.getOrDefault(s.charAt(i),0)+1);
            mapT.put(t.charAt(i),mapT.getOrDefault(t.charAt(i),0)+1);
        }
        for(char ch : mapS.keySet())
        {
            if(!mapT.containsKey(ch) || !mapS.get(ch).equals(mapT.get(ch)))
            {
                return false;
            }
        }
        return true;
    }
}