package BeginnerProblems.basicStrings;

/*

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:
Input : s = "abcde" , goal = "cdeab"
Output : true
Explanation :
After performing 2 shifts we can achieve the goal string from string s.
After first shift the string s is => bcdea
After second shift the string s is => cdeab.

Example 2:
Input : s = "abcde" , goal = "adeac"
Output : false
Explanation :
Any number of shift operations cannot convert string s to string goal.


Constraints:
1 <= s.length <= 100
1 <= goal.length <= 100
s and goal consist of only lowercase English letters.

EASY
*/

class Solution1
{   
    public boolean rotateString(String s, String goal) 
    {
        // brute
        if(s.length()!=goal.length())
        {
            return false;
        }
        if(s.length()==0)
        {
            return true;
        }
        int l=s.length();
        int counter=l;
        char arr[]=s.toCharArray();
        while(counter!=0)
        {
            char firstLeft=arr[0];
            for(int i=0;i<l-1;i++)
            {
                arr[i]=arr[i+1];
            }
            arr[l-1]=firstLeft;
            if((new String(arr)).equals(goal))
            {
                return true;
            }
            counter--;
        }
        return false;
    }
}

class Solution2
{   
    public boolean rotateString(String s, String goal) 
    {
        // better
        if(s.length()!=goal.length())
        {
            return false;
        }
        if(s.length()==0)
        {
            return false;
        }
        int n=s.length();
        StringBuilder str=new StringBuilder(s);
        while(n!=0)
        {
            char left=str.charAt(0);
            str.deleteCharAt(0);
            str.append(left);
            if(str.toString().equals(goal))
            {
                return true;
            }
            n--;
        }
        return false;
    }
}

class Solution3
{   
    public boolean rotateString(String s, String goal) 
    {
        // optimal
        if(s.length()!=goal.length())
        {
            return false;
        }
        String concat=s+s;
        return concat.contains(goal);
    }
}