package BeginnerProblems.basicStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

You are given a string s. 
Return the array of unique characters, sorted by highest to lowest occurring characters.
If two or more characters have same frequency then arrange them in alphabetic order.

Example 1:
Input : s = "tree"
Output : ['e', 'r', 't' ]
Explanation :
The occurrences of each character are as shown below :
e --> 2
r --> 1
t --> 1.
The r and t have same occurrences , so we arrange them by alphabetic order.

Example 2:
Input : s = "raaaajj"
Output : ['a' , 'j', 'r' ]
Explanation :
The occurrences of each character are as shown below :
a --> 4
j --> 2
r --> 1


Constraints:
1 <= s.length <= 105
s consist of only lowercase English characters.

EASY
*/

class Solution 
{    
    public List<Character> frequencySort(String s) 
    {
        //optimal
        // bucket Sort
        List<Character> result=new ArrayList<>();
        List<Character> bucket[]=new ArrayList[s.length()+1];
        Map<Character,Integer> dict=new HashMap<>();
        for(char c : s.toCharArray())
        {
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        for(char c : dict.keySet())
        {
            int frequency=dict.get(c);
            if(bucket[frequency]==null)
            {
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(c);   
        }
        for(int i=bucket.length-1;i>=1;i--)
        {
            if(bucket[i]!=null)
            {
                Collections.sort(bucket[i]);
                for( Character c : bucket[i])
                {
                    result.add(c);
                }
            }
        }
        return result; 
    }
}