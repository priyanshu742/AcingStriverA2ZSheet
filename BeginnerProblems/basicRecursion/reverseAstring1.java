package BeginnerProblems.basicRecursion;

import java.util.ArrayList;

/* 

Given an input string as an array of characters, write a function that reverses the string.

Example 1:
Input : s = ["h", "e", "l", "l", "o"]
Output : ["o", "l", "l", "e", "h"]
Explanation : The given string is s = "hello" and after reversing it becomes s = "olleh".

Example 2:
Input : s = ["b", "y", "e" ]
Output : ["e", "y", "b"]
Explanation : The given string is s = "bye" and after reversing it becomes s = "eyb".


Constraints:
1 <= s.length <= 103
s consist of only lowercase and uppercase English characters.

EASY
*/

class Solution 
{
    public ArrayList<Character> reverseString(ArrayList<Character> s) 
    {
        int low=0;
        int high=s.size()-1;
       
        return swap(s,low,high);
    }

    public ArrayList<Character> swap(ArrayList<Character> s,int low,int high)
    {
        if(low>=high)
        {
            return s;
        }
        char temp=s.get(low);
        s.set(low,s.get(high));
        s.set(high,temp);

        return swap(s,low+1,high-1);
    } 
}