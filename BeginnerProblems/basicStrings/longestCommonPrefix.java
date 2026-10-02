package BeginnerProblems.basicStrings;


/*

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input : str = ["flowers" , "flow" , "fly", "flight" ]
Output : "fl"
Explanation : All strings given in array contains common prefix "fl".

Example 2:
Input : str = ["dog" , "cat" , "animal", "monkey" ]
Output : ""
Explanation : There is no common prefix among the given strings in array.


Constraints:
1 <= str.length <= 200
1 <= str[i].length <= 200
str[i] contains only lowercase English letters.

MEDIUM
*/

class Solution1 
{    
    public String longestCommonPrefix(String[] str) 
    {
        // brute
        int i=0;
        while(i<str[0].length())
        {
            String check=str[0].substring(0,i+1);
            int flag=0;
            for(int j=1;j<str.length;j++)
            {
                if(!str[j].startsWith(check))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                break;
            }
            i++;
        }
        return str[0].substring(0,i);
    }
}

class Solution2 
{    
    public String longestCommonPrefix(String[] str) 
    {
        // better
        if(str==null || str.length==0)
        {
            return "";
        }
        String prefix=str[0];
        for(int i=1;i<str.length;i++)
        {
            while(!str[i].startsWith(prefix))
            {
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())
                {
                    return "";
                }
            }
        }
        return prefix;
    }
}

class Solution3 
{    
    public String longestCommonPrefix(String[] str) 
    {
        // slightly optimal
        if(str==null || str.length==0)
        {
            return "";
        }
        int low=0;
        int ans=0;
        int high=Integer.MAX_VALUE;
        for(String s : str)
        {
            if(s.length()<high)
            {
                high=s.length();
            }
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isCommonPrefix(str ,mid))
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return str[0].substring(0,ans);
    }
    public boolean isCommonPrefix(String[] str,int mid)
    {
        String check=str[0].substring(0,mid);
        for(int i=1;i<str .length;i++)
        {
            if(!str[i].startsWith(check))
            {
                return false;
            }
        }
        return true;
    } 
}

