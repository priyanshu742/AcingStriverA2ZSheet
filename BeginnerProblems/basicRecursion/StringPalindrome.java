package BeginnerProblems.basicRecursion;

/*

Given a string s, return true if the string is palindrome, otherwise false.
A string is called palindrome if it reads the same forward and backward.

Example 1
Input : s = "hannah"
Output : true
Explanation : The string when reversed is --> "hannah", which is same as original string ,
so we return true.

Example 2
Input : s = "aabbaA"
Output : false
Explanation : The string when reversed is --> "Aabbaa", which is not same as original string, 
So we return false.


Constraints
1 <= s.length <= 103
s consist of only uppercase and lowercase English characters.

*/

class Solution1
{   
    public boolean palindromeCheck(String s) 
    {
        String check=s;
        char[] charArray=s.toCharArray();

        return check.equals(reverse(charArray,0,s.length()-1));       
    }

    public String reverse(char arr[],int low,int high)
    {
        if(low>=high)
        {
            return new String(arr);
        }
        char temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
        return reverse(arr,low+1,high-1);
    } 
}

class Solution2
{   
    public boolean palindromeCheck(String s) 
    {
        // optimal
        return check(s,0,s.length()-1);
    }
    public boolean check(String s,int low,int high) 
    {
        if(low>=high)
        {
            return true;
        }
        char left=s.charAt(low);
        char right=s.charAt(high);
        if(left!=right)
        {
            return false;
        }
        return check(s,low+1,high-1);
    }
}