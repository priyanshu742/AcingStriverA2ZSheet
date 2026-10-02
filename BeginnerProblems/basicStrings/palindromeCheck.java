package BeginnerProblems.basicStrings;

class Solution1 
{   
    public boolean palindromeCheck(String s) 
    {
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