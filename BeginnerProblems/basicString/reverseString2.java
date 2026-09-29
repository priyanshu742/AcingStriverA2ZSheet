package BeginnerProblems.basicString;

import java.util.List;

/*

Given a string, the task is to reverse it. The string is represented by an array of characters s.
Perform the reversal in place with O(1) extra memory.
Note: no need to return anything, modify the given list.

Example 1:
Input : s = ["h", "e" ,"l" ,"l" ,"o"]
Output : ["o", "l", "l", "e", "h"]
Explanation :
The given string is s = "hello" and after reversing it becomes s = "olleh".

Example 2:
Input : s = ["b", "y" ,"e" ]
Output : ["e", "y", "b"]
Explanation :
The given string is s = "bye" and after reversing it becomes s = "eyb".


Constraints:
1 <= s.length <= 105
s consist of only lowercase and uppercase English characters.

EASY
*/

class Solution1 
{
    public void reverseString(List<Character> s) 
    {
        int low=0;
        int high=s.size()-1;
        while(low<high)
        {
            char temp=s.get(low);
            s.set(low,s.get(high));
            s.set(high,temp);
            low++;
            high--;
        }
    }
}

class Solution2
{
    public void reverseString(List<Character> s) 
    {
        int n=s.size();
        for(int i=0;i<n/2;i++)
        {
            char temp=s.get(i);
            s.set(i,s.get(n-i-1));
            s.set(n-i-1,temp);
        }
    }
}