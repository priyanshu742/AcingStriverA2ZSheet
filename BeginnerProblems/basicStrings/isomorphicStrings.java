package BeginnerProblems.basicStrings;

import java.util.HashMap;
import java.util.Map;

/*

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

Example 1:
Input : s = "egg" , t = "add"
Output : true
Explanation :
The 'e' in string s can be replaced with 'a' of string t.
The 'g' in string s can be replaced with 'd' of t.
Hence all characters in s can be replaced to get t.

Example 2:
Input : s = "apple" , t = "bbnbm"
Output : false
Explanation :
Strings are matched index by index.
At index 0, 'a' maps to 'b'.
At index 1, 'p' also maps to 'b'.
This is invalid because two different characters (a and p) cannot map to the same character (b) in a one-to-one mapping.
Therefore, no valid mapping exists and the output is false.


Constraints:
1 <= s.length <= 103
s.length == t.length
s and t consist of only lowercase English letters.

MEDIUM
*/

class Solution1 
{
    public boolean isomorphicString(String s, String t) 
    {
        // slow due to HashMap
        if(s.length() != t.length())
        {
            return false;
        }
        Map<Character,Character> mapST=new HashMap<>();
        Map<Character,Character> mapTS=new HashMap<>();
       
        for(int i=0;i<s.length();i++)
        {
            char charS=s.charAt(i);
            char charT=t.charAt(i);

            // check s->t mapping
            if(mapST.containsKey(charS))
            {
                if(mapST.get(charS)!=charT)
                {
                    return false;
                }
            }
            else
            {
                mapST.put(charS,charT);
            }
            
            // check t->s mapping
            if(mapTS.containsKey(charT))
            {
                if(mapTS.get(charT)!=charS)
                {
                    return false;
                }
            }
            else
            {
                mapTS.put(charT,charS);
            }
        }
        return true;
    }
}

class Solution2 
{
    public boolean isomorphicString(String s, String t) 
    {
        // optimal
        if(s.length()!=t.length())
        {
            return false;
        }
        int lastSeenS[]=new int[256];
        int lastSeenT[]=new int[256];
        for(int i=0;i<s.length();i++)
        {
            char charS=s.charAt(i);
            char charT=t.charAt(i);
            if(lastSeenS[charS]!=lastSeenT[charT])
            {
                return false;
            }
            lastSeenS[charS]=i+1;
            lastSeenT[charT]=i+1;
        }
        return true;
    }
}