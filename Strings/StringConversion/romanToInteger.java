package Strings.StringConversion;

import java.util.HashMap;
import java.util.Map;

/*

Roman numerals are represented by seven different symbols:

I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000
Roman numerals are typically written from largest to smallest, left to right. 
However, in specific cases, a smaller numeral placed before a larger one indicates subtraction.

The following subtractive combinations are valid:
I before V (5) and X (10) → 4 and 9
X before L (50) and C (100) → 40 and 90
C before D (500) and M (1000) → 400 and 900
Given a Roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 1 + 1 + 1 = 3

Example 2:
Input: s = "XLII"
Output: 42
Explanation: XL = 40, II = 2 → 40 + 2 = 42


Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')
It is guaranteed that s is a valid Roman numeral in the range [1, 3999]

EASY
*/

class Solution 
{
    public int romanToInt(String s) 
    {
        // optimal
        int ans=0;
        Map<Character,Integer> value=new HashMap<>();
        value.put('I',1);
        value.put('V',5);
        value.put('X',10);
        value.put('L',50);
        value.put('C',100);
        value.put('D',500);
        value.put('M',1000);
        for(int i=0;i<s.length()-1;i++)
        {
            char c1=s.charAt(i);
            char c2=s.charAt(i+1);
            int v1=value.get(c1);
            int v2=value.get(c2);
            if(v1<v2)
            {
                ans=ans-v1;
            }
            else
            {
                ans=ans+v1;
            }
        }
        ans=ans+value.get(s.charAt(s.length()-1));
        return ans;
    }
}
