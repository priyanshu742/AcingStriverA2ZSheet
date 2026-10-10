package BeginnerProblems.basicStrings;

/*

You are given a string s. Return true if the string is palindrome, otherwise false.
A string is called palindrome if it reads the same forward and backward.

Example 1:
Input : s = "hannah"
Output : true
Explanation :
The given string when read backward is -> "hannah", which is same as when read forward.
Hence answer is true.

Example 2:
Input : s = "aabbaaa"
Output : false
Explanation :
The given string when read backward is -> "aaabbaa", which is not same as when read forward.
Hence answer is false.

Constraints:
1 <= s.length <= 105
s consist of only uppercase and lowercase English characters.

EASY
*/

class Solution1 
{   
    public boolean palindromeCheck(String s) 
    {
        // optimal
        int low=0;
        int high=s.length()-1;
        while(low<high)
        {
            char left=s.charAt(low);
            char right=s.charAt(high);

            if(left!=right)
            {
                return false;
            }
            /*

            if(s.charAt(low)!=s.charAt(high))
            {
                return false;
            }
            
            */
            low++;
            high--;
            
        }
        return true;
    }
}

class Solution2 
{   
    public boolean palindromeCheck(String s) 
    {
        // brute
        String check=s;
        int low=0;
        int high=s.length()-1;
        char arr[]=s.toCharArray();
        while(low<high)
        {
            char temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
        return check.equals(new String(arr));
    }
}

class Solution 
{   
    public boolean palindromeCheck(String s) 
    {
        // brute
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}