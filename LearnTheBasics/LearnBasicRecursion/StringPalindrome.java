package LearnTheBasics.LearnBasicRecursion;



/*

Given a string s, return true if the string is palindrome, otherwise false.
A string is called palindrome if it reads the same forward and backward.

Example 1
Input : s = "hannah"
Output : true
Explanation : The string when reversed is --> "hannah", which is same as original string , so we return true.

Example 2
Input : s = "aabbaA"
Output : false
Explanation : The string when reversed is --> "Aabbaa", which is not same as original string, So we return false.


Constraints
1 <= s.length <= 103
s consist of only uppercase and lowercase English characters.

*/


class Solution 
{   
    public boolean palindromeCheck(String s) 
    {
        String check=s;
        int size=s.length();
        int first=0;
        int last=size-1;
        String change=swap(s,first,last);

        return check.equals(change);
    }

    public String swap(String s,int first,int last)
    {
        if(first>=last)
        {
            return s;
        }
        else
        {
            char rev[]=s.toCharArray();
            char temp=rev[first];
            rev[first]=rev[last];
            rev[last]=temp;

            String modifiedString= new String(rev);
        
            return swap(modifiedString,first+1,last-1);
        }
    } 
}
